name := "SparkGeneric"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "MQTT Repository" at "https://repo.eclipse.org/content/repositories/paho-releases/"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming" % "1.3.0",
  "org.apache.spark" %% "spark-streaming-twitter" % "1.3.0",
  "org.twitter4j" % "twitter4j-stream" % "3.0.3",
  "org.apache.spark" %% "spark-sql" % "1.3.0",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.google.inject" % "guice" % "4.0",
  "org.apache.spark" %% "spark-streaming-mqtt" % "1.3.0",
  "org.eclipse.paho" % "mqtt-client" % "0.4.0"
)
    
