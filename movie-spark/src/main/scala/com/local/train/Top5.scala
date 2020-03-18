package com.local.train

import com.local.caseclass.RatingsTimestamp
import com.local.conf.AppConf
import org.apache.spark.sql.SaveMode

/**
  * @author Michael Chu
  * @since 2020-03-18 13:51
  */
object Top5 extends AppConf{

  def main(args: Array[String]): Unit = {
    import sqlContext.implicits._
    val ratings = sc.textFile("movie-spark/data/ratings.txt", 8).filter { !_.endsWith(",") }
      .map(_.split(",")).map(x => RatingsTimestamp(x(0).trim().toInt, x(1).trim().toInt, x(2).trim().toDouble, x(3).trim.toInt)).toDF()

    ratings.write.mode(SaveMode.Overwrite).parquet("/tmp/ratings")
    hc.sql("drop table if exists ratings")
    hc.sql("create table if not exists ratings(userId int,movieId int,rating double,timestamp int) stored as parquet")
    hc.sql("load data inpath '/tmp/ratings' overwrite into table ratings")

    // 调用cache table tableName即可将一张表缓存到内存中，来极大的提高查询效率
    val ratingsData = hc.sql("cache table ratings")

    val pop = hc.sql("select count(*) as c ,movieId from trainingData group by movieId order by c desc")
    val pop5 = pop.select("movieId").limit(5)
    pop5.registerTempTable("pop5")
    val pop5result = hc.sql("select a.movieId,a.title from movies a join pop5 b where a.movieId=b.movieId")

    pop5result.write.mode(SaveMode.Append).jdbc(jdbcURL, top5Table, prop)
  }

}
