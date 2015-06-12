package core

/**
 * Created by jsmammen on 6/12/15.
 */


object TwitterSparkJob extends TwitterJob {


  def start(args: Array[String]) {

    //Getting the implementation of injestors/digesters/analyzers
    val dataStream = injestor.injest(ssc) // returns Dstream

    //Processing it
    val analytics = analyzer.analyze(dataStream)

    ssc.start()
    println(">>>-STARTED WAITING STREAMING for Twitter---")
    ssc.awaitTermination()

  }
}
