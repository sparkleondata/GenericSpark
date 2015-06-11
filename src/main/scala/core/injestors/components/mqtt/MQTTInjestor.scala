package core.injestors.components.mqtt

import org.apache.spark.storage.StorageLevel
import org.eclipse.paho.client.mqttv3._
import org.eclipse.paho.client.mqttv3.persist._


import com.google.inject.Inject
import com.google.inject.name.Named
import core.injestors.InjestorComponent
import org.apache.spark.streaming.StreamingContext

import org.apache.spark.streaming.mqtt._

/**
 * Created by jsmammen on 6/11/15.
 */
class MQTTInjestor extends InjestorComponent {

  var brokerUrl:String = null
  var port:String = null
  var topic:String = null

  @Inject
  def this(@Named("MQTTHost") host: String, @Named("MQTTPort") port: String,
           @Named("MQTTTopic") topic: String) = {
    this()
    this.brokerUrl=host
    this.port = port
    this.topic = topic
  }


  override def injest(ssc: Any): Any = {

    val lines = MQTTUtils.createStream(ssc.asInstanceOf[StreamingContext], brokerUrl, topic, StorageLevel.MEMORY_ONLY_SER_2)
    println("Broker url "+brokerUrl)
    println("Broker topic "+topic)

    lines.print()

    return lines


  }

}