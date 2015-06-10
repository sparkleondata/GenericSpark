import java.sql.DriverManager

import com.google.inject.Inject
import core.TwitterJob
import core.analyzers.AnalyzerComponent
import core.digestors.DigestorComponent
import core.injestors.InjestorComponent
import core.injestors.components.twitter.TwitterHelper
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


/**
 *
 * Created by jsmammen on 5/18/15.
 */
object TwitterSpark extends TwitterJob {


  def main(args: Array[String]) {

    //Getting the implementation of injestors/digesters/analyzers
    val dataStream = injestor.injest(ssc) // returns Dstream

    //Processing it
    val analytics = analyzer.analyze(dataStream)

    ssc.start()
    println(">>>-STARTED WAITING STREAMING ---")
    ssc.awaitTermination()

  }

}
