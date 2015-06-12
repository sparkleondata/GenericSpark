package core

import core.digestors.DigestorComponent


/**
 *
 * Created by jsmammen on 6/12/15.
 */
object MQTTSparkJob extends MQTTJob {

  def start(args: Array[String]) {
    //Getting the implementation of injestors/digesters/analyzers
    val dataStream = injestor.injest(ssc) // returns Dstream
    //Processing it
    val sensorValues = digestor.digest(dataStream)

    ssc.start()
    println(">>>-STARTED WAITING STREAMING MQTT ---")
    ssc.awaitTermination()

  }

}
