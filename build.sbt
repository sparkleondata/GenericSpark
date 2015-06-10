name := "TwitterSparkGeneric"

version := "1.0"

scalaVersion := "2.10.4"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming" % "1.3.0",
  "org.apache.spark" %% "spark-streaming-twitter" % "1.3.0",
  "org.twitter4j" % "twitter4j-stream" % "3.0.3",
  "org.apache.spark" %% "spark-sql" % "1.3.0",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.google.inject" % "guice" % "4.0"
)
    
