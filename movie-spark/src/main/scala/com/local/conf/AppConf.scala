package com.local.conf

import java.io.File
import java.util.Properties

import com.local.utils.LoggerLevels
import org.apache.hadoop.fs.FileSystem
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.hive.HiveContext

/**
  * 配置类
  *
  * @author Michael Chu
  * @since 2020-03-10 12:52
  */
trait AppConf {

  val path = new File(".").getCanonicalPath()
  //File workaround = new File(".");
  System.getProperties.put("hadoop.home.dir", path)
  new File("./movie-spark/bin").mkdirs()
  new File("./movie-spark/bin/winutils.exe").createNewFile()

  //去除提示信息
  LoggerLevels.setStreamingLogLevels()

  // 配置信息
  val jdbcURL = "jdbc:mysql://hadoop000:3306/movie?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT"
  val alsTable = "movie.alsTab"
  val recResultTable = "movie.similartab"
  val top5Table = "movie.top5result"
  val userTable= "movie.user"
  val ratingTable= "movie.rating"
  val mysqlUsername = "root"
  val mysqlPassword = "root"
  val prop = new Properties
  prop.put("driver", "com.mysql.cj.jdbc.Driver")
  prop.put("user", mysqlUsername)
  prop.put("password", mysqlPassword)


  val conf = new SparkConf().setAppName("AppConf").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val hc = new HiveContext(sc)
  val sqlContext = new SQLContext(sc)
  val fs = FileSystem.get(sc.hadoopConfiguration)
}
