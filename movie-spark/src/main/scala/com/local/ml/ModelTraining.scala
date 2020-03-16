package com.local.ml

import com.local.conf.AppConf
import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.rdd.RDD

/**
  * @author Michael Chu
  * @since 2020-03-10 17:29
  */
object ModelTraining extends AppConf {

  def main(args: Array[String]): Unit = {
    // 读取电影信息
    val movies = sc.textFile("movie-spark/data/movies.dat").map(line => {
      val fields = line.split("\\,")
      (fields(0).toInt, fields(1))
    }).collect().toMap

    // 读取评分数据
    val ratings = sc.textFile("movie-spark/data/ratings.dat").map(line => {
      val fields = line.split("\t")
      val rating = Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
      val timestamp = fields(3).toLong % 10
      (timestamp, rating)
    })

    // 输出基本信息
    val numRatings = ratings.count()
    val numUsers = ratings.map(_._2.user).distinct().count()
    val numMovies = ratings.map(_._2.product).distinct().count()
    println("Got " + numRatings + " ratings from " + numUsers + " users on " + numMovies + " movies")

    // 训练集 ：验证集 ：测试集 = 6 ： 2 ： 2
    val training = ratings.filter(x => x._1 < 6).map(x => x._2)
    val validation=ratings.filter(x=>x._1>=6 && x._1<8).map(x=>x._2)
    val test=ratings.filter(x=>x._1>=8).map(x=>x._2)

    val numTraining = training.count()
    val numValidation = validation.count()
    val numTest = test.count()
    println("Training: " + numTraining + ", Validation: " + numValidation + ",Test: " + numTest)

    // 使用不同参数训练协同过滤模型
    val ranks = List(10, 20, 50, 60, 70, 80, 90, 100)
    val lambdas=List(0.001, 0.005, 0.01, 0.015, 0.02, 0.1)
    val numIters=List(10,20)

    var bestValidationRmse = Double.MaxValue
    var bestRank = 1
    var bestLambda = 0.0
    var bestNumIter = 0
    var bestModel = ALS.train(training, bestRank, bestNumIter, bestLambda)

    for (rank <- ranks; lambda <- lambdas; numIter <- numIters) {
      val model = ALS.train(training, rank, numIter, lambda)
      val validationRmse = computeRmse(model, validation)
      if (validationRmse < bestValidationRmse) {
        bestModel = model
        bestValidationRmse = validationRmse
        bestRank = rank
        bestLambda = lambda
        bestNumIter = numIter
      }
    }

    val testRmse = computeRmse(bestModel,test)
    bestModel.save(sc,"movie-spark/model/")
    println("The best model was trained with rank= " + bestRank +
      " and lambda= " + bestLambda +
      ", and numIter= " + bestNumIter +
      ", and its RMSE on the test set is " + testRmse + ".")
  }

  def computeRmse(model: MatrixFactorizationModel, data: RDD[Rating]): Double = {
    val predict=model.predict(data.map(x=>(x.user,x.product)))

    val predictionsAndRatings=predict.map(x=>{
      ((x.user,x.product),x.rating)
    }).join(data.map(x=>((x.user,x.product), x.rating))).values

    val MSE = predictionsAndRatings.map {x =>
      (x._1 - x._2) * (x._1 - x._2)
    }.mean()
    MSE
  }

}
