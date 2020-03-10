package com.local.etl


import com.local.conf.AppConf
import org.apache.hadoop.fs.Path
import org.apache.spark.mllib.recommendation.Rating

/**
  * 训练ETL
  *
  * @author Michael Chu
  * @since 2020-03-10 13:04
  */
object TrainETL extends AppConf {

  def main(args: Array[String]): Unit = {
    val ratings = sc.textFile("movie-spark/data/ratings.dat").map(line => {
      val fields = line.split("\t")
      val rating = Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
      val timestamp = fields(3).toLong % 10
      (timestamp, rating)
    })

    val training = ratings.filter(x => x._1 < 6).map(x => {
      x._2.user + "\t" + x._2.product + "\t" + x._2.rating
    })

    val savePath = "movie-spark/data/training"
    fs.delete(new Path(savePath), true)
    training.saveAsTextFile(savePath)
  }
}
