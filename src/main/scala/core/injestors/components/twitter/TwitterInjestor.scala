package core.injestors.components.twitter

import com.google.inject.Inject
import com.google.inject.name.Named
import core.injestors.InjestorComponent
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.twitter.TwitterUtils

/**
 * Created by jsmammen on 5/18/15.
 */
class TwitterInjestor extends InjestorComponent {

  @Inject
  def this(@Named("consumerKey") consumerKey: String, @Named("consumerSecret") consumerSecret: String,
           @Named("accessToken") accessToken: String, @Named("accessTokenSecret") accessTokenSecret: String) = {
    this()
    TwitterHelper.configureTwitterCredentials(consumerKey, consumerSecret, accessToken, accessTokenSecret)
  }


  override def injest(ssc: Any): Any = {

    val stream = TwitterUtils.createStream(ssc.asInstanceOf[StreamingContext], None) //ssc.twitterStream()

    val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")).filterNot(_.startsWith("#FOLLOW")).filterNot(_.startsWith("#ff")).filterNot(_.startsWith("#follow")).filterNot(_.startsWith("#FF")))

    return hashTags


  }
}
