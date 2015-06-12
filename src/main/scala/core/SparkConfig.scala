package core

import com.google.inject.Inject
import com.google.inject.name.Named
import core.digestors.DigestorComponent
import core.injestors.components.twitter.TwitterHelper

/**
 * Created by jsmammen on 6/1/15.
 */
object SparkConfig {


  val sparkHome = "/home/android/spark-1.3.0-bin-hadoop2.4"
  // URL of the Spark cluster
  val sparkUrl = TwitterHelper.getSparkUrl()
  // Location of the required JAR files
  val jarFile = "/home/android/IdeaProjects/TwitterSpark/target/scala-2.10/twitter-spark_2.10-1.0.jar"
  // HDFS directory for checkpointing
  val checkpointDir = "./checkpoint/"

  val appname = "TwitterGeneric"

  val streamwindow = 60

}
