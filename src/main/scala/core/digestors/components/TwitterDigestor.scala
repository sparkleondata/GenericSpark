package core.digestors.components


import core.digestors.DigestorComponent

/**
 * Created by jsmammen on 5/18/15.
 */
class TwitterDigestor extends DigestorComponent {

  override def digest(mylist: Any): Any = {

    println("IN DIGESTER DIGESTING -->>")
    val topList = mylist.asInstanceOf[scala.Array[(Int, String)]]
    topList.foreach { case (count, tag) => writeConsole(tag, count) }
  }

  def writeConsole(tag: String, count: Int) {
    println("%s -> %s".format(tag, count))
  }
}
