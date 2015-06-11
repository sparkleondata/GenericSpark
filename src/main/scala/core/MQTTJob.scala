package core

import com.google.inject.Guice
import core.analyzers.AnalyzerComponent
import core.digestors.DigestorComponent
import core.injestors.InjestorComponent
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by jsmammen on 5/18/15.
 */
trait MQTTJob extends GenericJob {

  val injector = Guice.createInjector(new MQTTJobDependencyModule)
  val injestor = injector.getInstance(classOf[InjestorComponent])
  val digestor = injector.getInstance(classOf[DigestorComponent])

  val sparkConf = new SparkConf().setMaster(sparkUrl).setAppName(appname)
  val sc = new SparkContext(sparkConf)
  val ssc = new StreamingContext(sc, Seconds(streamwindow))

}

