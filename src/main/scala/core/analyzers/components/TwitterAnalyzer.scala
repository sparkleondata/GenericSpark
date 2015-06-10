package core.analyzers.components

import com.google.inject.Inject
import core.analyzers.AnalyzerComponent
import core.digestors.DigestorComponent
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.dstream.DStream


/**
 * Created by jsmammen on 5/18/15.
 */


class TwitterAnalyzer extends AnalyzerComponent {

  var twitdigestor: DigestorComponent = null

  @Inject
  def this(twitdigestor: DigestorComponent) = {
    this()
    this.twitdigestor = twitdigestor

  }

  override def analyze(hashTags: Any): Any = {
    println("--<<<IN TwitterAnalyzer analyzing<<<< -->>")
    val topCounts60 = hashTags.asInstanceOf[DStream[String]].map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(60))
      .map { case (topic, count) => (count, topic) }
      .transform(_.sortByKey(false))


    topCounts60.foreachRDD(rdd => {
      val totalTweets = rdd.count()
      val topList = rdd.take(5)
      println("\nPopular topics in last 600 seconds (%s total):".format(totalTweets))
      twitdigestor.digest(topList)
    })
  }
}
