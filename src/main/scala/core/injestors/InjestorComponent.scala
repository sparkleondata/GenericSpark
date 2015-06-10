package core.injestors

/**
 * Created by jsmammen on 5/18/15.
 */
trait InjestorComponent {
  def injest(o: Any): Any
}
