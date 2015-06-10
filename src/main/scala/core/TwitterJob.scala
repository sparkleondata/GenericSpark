package core


import com.google.inject.name.Named
import com.google.inject.{Inject, Guice}
import core.analyzers.AnalyzerComponent
import core.digestors.DigestorComponent
import core.injestors.InjestorComponent
import core.injestors.components.twitter.TwitterHelper
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by jsmammen on 5/18/15.
 */
trait TwitterJob extends GenericJob {

  val injector = Guice.createInjector(new TwitterJobDependencyModule)
  val injestor = injector.getInstance(classOf[InjestorComponent])
  val analyzer = injector.getInstance(classOf[AnalyzerComponent])
  val digestor = injector.getInstance(classOf[DigestorComponent])

  val sparkConf = new SparkConf().setMaster(sparkUrl).setAppName(appname)
  val sc = new SparkContext(sparkConf)
  val ssc = new StreamingContext(sc, Seconds(streamwindow))

}

