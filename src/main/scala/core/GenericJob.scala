package core

import com.google.inject.Inject
import com.google.inject.name.Named
import core.injestors.components.twitter.TwitterHelper


/**
 * Created by jsmammen on 5/18/15.
 */
trait GenericJob {

  val sparkHome = SparkConfig.sparkHome
  // URL of the Spark cluster
  val sparkUrl = SparkConfig.sparkUrl
  // Location of the required JAR files
  val jarFile = SparkConfig.jarFile
  // HDFS directory for checkpointing
  val checkpointDir = SparkConfig.checkpointDir

  val appname = SparkConfig.appname

  val streamwindow = SparkConfig.streamwindow

}

