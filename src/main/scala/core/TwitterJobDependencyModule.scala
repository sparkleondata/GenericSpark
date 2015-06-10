package core

/**
 * Created by jsmammen on 5/18/15.
 */


import java.util.Properties

import com.google.inject.name.Names
import com.google.inject.{Binder, Module}
import core.analyzers.AnalyzerComponent
import core.analyzers.components.TwitterAnalyzer
import core.digestors.DigestorComponent
import core.digestors.components.TwitterDigestor
import core.injestors.InjestorComponent
import core.injestors.components.twitter.TwitterInjestor


class TwitterJobDependencyModule extends Module {

  def configure(binder: Binder) = {

    val properties = new Properties
    try {
      properties.load(this.getClass().getResourceAsStream("/sparkjob.properties"))
      Names.bindProperties(binder, properties)
    } catch {
      case e: Exception => println("Exception during loading configuration " + e.printStackTrace())
    }

    binder.bind(classOf[InjestorComponent]) to (classOf[TwitterInjestor])
    binder.bind(classOf[DigestorComponent]) to (classOf[TwitterDigestor])
    binder.bind(classOf[AnalyzerComponent]) to (classOf[TwitterAnalyzer])

  }


}