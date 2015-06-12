/**
 *
 * Created by jsmammen
 */

//Main class to call other jobs

import core.{TwitterSparkJob, MQTTSparkJob}

object GenericSpark {


  def main(args: Array[String]) {
    //Starting the MQTT job
    //MQTTSparkJob.start(null)

    //Starting Twiitetr job
    TwitterSparkJob.start(null)

  }

}
