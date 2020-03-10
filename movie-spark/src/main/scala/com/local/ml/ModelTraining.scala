package com.local.ml

import com.local.conf.AppConf
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel

/**
  * @author Michael Chu
  * @since 2020-03-10 17:29
  */
object ModelTraining extends AppConf {

  def main(args: Array[String]): Unit = {

  }

  def computeRmse(model:MatrixFactorizationModel): Double = {
    2F
  }

}
