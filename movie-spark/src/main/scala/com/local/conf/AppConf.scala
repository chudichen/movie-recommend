package com.local.conf

import java.io.File

import com.local.utils.LoggerLevels
import org.apache.hadoop.fs.FileSystem
import org.apache.spark._
import org.apache.spark.sql._

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

  val conf = new SparkConf().setAppName("AppConf").setMaster("local")
  val sc = new SparkContext(conf)

  val sqlContext = new SQLContext(sc)

  val fs = FileSystem.get(sc.hadoopConfiguration)
}
