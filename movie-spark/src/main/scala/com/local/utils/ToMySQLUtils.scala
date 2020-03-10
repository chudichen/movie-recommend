package com.local.utils

import org.apache.spark.sql.{DataFrame, SaveMode}

/**
  * 保存到数据库
  *
  * @author Michael Chu
  * @since 2020-03-10 15:15
  */
object ToMySQLUtils {

  def toMySQL(df:DataFrame, tableName: String, saveMode: SaveMode): Unit = {
    val prop = new java.util.Properties()
    prop.setProperty("user", "root")
    prop.setProperty("password", "root")

    df.write.mode(saveMode).jdbc("jdbc:mysql://hadoop000:3306/movie", tableName, prop)
  }

}
