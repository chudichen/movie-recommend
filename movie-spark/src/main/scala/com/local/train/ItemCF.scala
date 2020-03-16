package com.local.train

import com.local.caseclass.ItemPref
import com.local.conf.AppConf
import org.apache.spark.sql.SaveMode

/**
  * 根据ratings.txt，格式为(userId,movieId,rating)生成电影相似度表
  *
  * @author Michael Chu
  * @since 2020-03-16 17:10
  */
object ItemCF extends AppConf {

  def main(args: Array[String]): Unit = {
    import sqlContext.implicits._
    // 2 读取样本数据
    val data_path = "movie-spark/data/ratings.dat"
    val data = sc.textFile(data_path, 8)
    val userdata = data.map(_.split("\t")).map(f => ItemPref(f(0), f(1), f(2).toDouble)).cache()

    // 3 建立模型
    val mysimil = new ItemSimilarity()
    val simil_rdd1 = mysimil.similarity(userdata, "cooccurrence")

    val simiDF = simil_rdd1.filter(x => x.similar >= 0.4).toDF()
    simiDF.show()
    // 存储结果至数据库
//    simiDF.write.mode(SaveMode.Append).jdbc(jdbcURL, recResultTable, prop)
  }
}
