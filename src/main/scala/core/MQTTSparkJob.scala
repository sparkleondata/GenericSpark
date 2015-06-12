package core


/**
 *
 * Created by jsmammen on 5/18/15.
 */
object MQTTSparkJob extends MQTTJob {

  def start(args: Array[String]) {
    //Getting the implementation of injestors/digesters/analyzers
    val dataStream = injestor.injest(ssc) // returns Dstream
    //Processing it
    ssc.start()
    println(">>>-STARTED WAITING STREAMING MQTT ---")
    ssc.awaitTermination()

  }

}
