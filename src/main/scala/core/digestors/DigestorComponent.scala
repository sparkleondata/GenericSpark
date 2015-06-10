package core.digestors

/**
 * Created by jsmammen on 5/18/15.
 */
trait DigestorComponent {
  def digest(s: Any): Any
}
