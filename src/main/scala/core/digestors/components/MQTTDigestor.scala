package core.digestors.components

import core.digestors.DigestorComponent
import org.apache.spark.streaming.dstream.DStream

/**
 * Created by jsmammen on 5/18/15.
 */
class MQTTDigestor extends DigestorComponent {

  override def digest(mylist: Any): Any = {

    println("IN MQTTDigestor DIGESTING -->>org.apache.spark.streaming.dstream.FlatMappedDStream")
    val topList = mylist.asInstanceOf[DStream[ String]]

    topList.foreachRDD( rdd => {
      for(item <- rdd.collect().toArray) {
        writeConsole(item); //this could be database or other output
      }
    })

  }

  def writeConsole(count: String) {
    println("Temp reading -> %s".format(count))
  }
}
