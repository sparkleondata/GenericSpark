package core.injestors.components

import core.injestors.InjestorComponent

/**
 * Created by jsmammen on 5/18/15.
 */
class SampleInjestorComponent extends InjestorComponent {
  override def injest(a: Any): Any = {
    "Hello Injesting my stuff"
  }
}
