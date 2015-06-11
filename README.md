# Generic Spark
This is a  rewrite of Twitter example for Spark
http://ampcamp.berkeley.edu/3/exercises/realtime-processing-with-spark-streaming.html


Based on pluggable architecture  http://sparkleondata.com/pluggable-architecture/
You can plugin:
- Injestors
- Analyzers
- Digesters

http://sparkleondata.com/

To run the app
- setup the twitter credentials in sparkjob.properties
- then run 'sbt run'