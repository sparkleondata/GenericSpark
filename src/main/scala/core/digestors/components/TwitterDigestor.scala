package core.digestors.components

import java.sql.DriverManager

import core.TwitterJob
import core.digestors.DigestorComponent

/**
 * Created by jsmammen on 5/18/15.
 */
class TwitterDigestor extends DigestorComponent {

  override def dijest(mylist: Any): Any = {

    println("IN DIGESTER DIGESTING -->>")
    val topList = mylist.asInstanceOf[scala.Array[(Int, String)]]
    topList.foreach { case (count, tag) => println("%s, %s".format(tag, count)) }
    topList.foreach { case (count, tag) => writeJDBC(tag, count) }
  }

  def writeJDBC(tag: String, count: Int) {
    val url = "jdbc:mysql://localhost:3306/sgraph?useUnicode=true&characterEncoding=UTF-8"
    //?useUnicode=true&characterEncoding=UTF-8"
    val username = "root"
    val password = "android"

    // there's probably a better way to do this
    var connection: java.sql.Connection = null

    try {

      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      //statement.executeQuery("SELECT * FROM tophashtags")
      //val run = statement.executeUpdate("INSERT INTO tophashtags (hashtag,numtags) VALUES ('zzzzz',32)")
      val pstmt = connection.prepareStatement("INSERT INTO tophashtags (hashtag,numtags,other) VALUES (?,?,?)")
      var newtag = tag
      if (tag.length > 20) {
        newtag = tag.substring(1, 17) + "..."
      } else {
        newtag = tag.substring(1)
      }
      pstmt.setString(1, tag)
      pstmt.setInt(2, count)
      pstmt.setString(3, tag)
      pstmt.executeUpdate()
      println("?????????????????--->>>>>>>>After run %s", pstmt)

    } catch {
      case e: Exception => println("exception caught: " + e);

    }

  }

  def writeJDBCTotaltweets(count: Long) {
    val url = "jdbc:mysql://localhost:3306/sgraph?useUnicode=true&characterEncoding=UTF-8"
    //?useUnicode=true&characterEncoding=UTF-8"
    val username = "root"
    val password = "android"

    // there's probably a better way to do this
    var connection: java.sql.Connection = null

    try {

      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      //statement.executeQuery("SELECT * FROM tophashtags")
      //val run = statement.executeUpdate("INSERT INTO tophashtags (hashtag,numtags) VALUES ('zzzzz',32)")
      val pstmt = connection.prepareStatement("INSERT INTO totaltweets (totaltweets) VALUES (?)")

      pstmt.setLong(1, count)
      pstmt.executeUpdate()
      println("--->>>>>>>>Total Tweets run %s, %n", pstmt, count)

    } catch {
      case e: Exception => println("exception caught: " + e);

    }

  }

  def clearTopTweets() {
    val url = "jdbc:mysql://localhost:3306/sgraph"
    val username = "root"
    val password = "android"

    // there's probably a better way to do this
    var connection: java.sql.Connection = null

    try {

      connection = DriverManager.getConnection(url, username, password)

      //statement.executeQuery("SELECT * FROM tophashtags")
      //val run = statement.executeUpdate("INSERT INTO tophashtags (hashtag,numtags) VALUES ('zzzzz',32)")
      val pstmt = connection.prepareStatement("Truncate table tophashtags")
      pstmt.executeUpdate()
      println("?????????????????-Cleared table", pstmt)

    } catch {
      case e: Exception => println("exception caught: " + e);

    }

  }

}
