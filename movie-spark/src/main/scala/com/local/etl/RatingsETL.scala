package com.local.etl

import com.local.caseclass.Ratings
import com.local.conf.AppConf
import com.local.utils.ToMySQLUtils
import org.apache.spark.sql.SaveMode

/**
  * @author Michael Chu
  * @since 2020-03-10 12:59
  */
object RatingsETL extends AppConf {

  def main(args: Array[String]): Unit = {
    val ratingsRDD = sc.textFile("movie-spark/data/training").map(line => {
      val fields = line.split("\t")
      Ratings(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
    })

    import sqlContext.implicits._
    val ratingsDF = ratingsRDD.toDF
    ToMySQLUtils.toMySQL(ratingsDF,"rating", SaveMode.Append)
  }
}
