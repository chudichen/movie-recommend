package com.local.rec

import com.local.conf.AppConf
import org.apache.hadoop.fs.Path
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel


/**
  * @author Michael Chu
  * @since 2020-03-10 15:32
  */
object Recommend extends AppConf {

  def main(args: Array[String]): Unit = {
    val modelPath = "movie-spark/model/"
    val model = MatrixFactorizationModel.load(sc, modelPath)

    val uid = 6
    val rec = model.recommendProducts(uid, 5)

    val result = rec.map(x => x.user.toString + "|"
      + x.product.toString + "|" + x.rating.toString)
    val resultDFArray = sc.parallelize(result)
    val res = resultDFArray.map(line => {
      val fields = line.split("\\|")
      (fields(0).toInt,fields(1))
    })

    val savePathStr = "movie-spark/data/movie"
    val savePath = new Path(savePathStr)
    if (fs.exists(savePath)) {
      fs.delete(savePath, true)
    }

    res.reduceByKey((a, b) => a + "," + b).map(line => {
      line._1 + "\t" + line._2
    }).saveAsTextFile(savePathStr)
  }
}
