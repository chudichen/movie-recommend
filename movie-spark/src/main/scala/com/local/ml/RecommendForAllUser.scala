package com.local.ml

import java.util.Properties

import com.local.caseclass.Result
import com.local.conf.AppConf
import org.apache.spark.mllib.recommendation.{MatrixFactorizationModel, Rating}
import org.apache.spark.sql.{SQLContext, SaveMode}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Michael Chu
  * @since 2020-03-16 11:37
  */
object RecommendForAllUser extends AppConf {

  def main(args: Array[String]): Unit = {
    val users = sqlContext.read.jdbc(jdbcURL, "user", prop).dropDuplicates(Seq("userid"))
    val allusers = users.rdd.map(_.getInt(0)).toLocalIterator

    val modelpath = "movie-spark/model1"
    val model = MatrixFactorizationModel.load(sc, modelpath)
    while (allusers.hasNext) {
      val rec = model.recommendProducts(allusers.next(), 5)
      writeRecResultToMysql(rec, sqlContext, sc)
      // writeRecResultToSparkSQL(rec)，写入到SPARK-SQL(DataFrame)+hive，同ETL。
      // writeRecResultToHbase(rec, sqlContext, sc)
    }

    def writeRecResultToMysql(uid: Array[Rating], sqlContext: SQLContext, sc: SparkContext): Unit = {
      val uidString = uid.map(x => x.user.toString + "," + x.product.toString + "," + x.rating.toString)
      import sqlContext.implicits._
      val uidDFArray = sc.parallelize(uidString)
      val uidDF = uidDFArray.map(_.split(",")).map(x => Result(x(0).trim.toInt, x(1).trim.toInt, x(2).trim.toDouble)).toDF
      // 写入mysql数据库，数据库配置在AppConf重
      uidDF.write.mode(SaveMode.Append).jdbc(jdbcURL, alsTable, prop)
    }
  }
}
