# Generic Spark
This is a  rewrite of Twitter example for Spark based on Pluggable approach
http://ampcamp.berkeley.edu/3/exercises/realtime-processing-with-spark-streaming.html


Based on pluggable architecture  http://sparkleondata.com/pluggable-architecture/
You can plugin:
- Injestors
- Analyzers
- Digesters


To run the app
- setup the twitter credentials in sparkjob.properties
- then run 'sbt run'

- added MQTT injestor for testing MQTT (this would require MQTT server running locally or remote to test)

You may visit http://sparkleondata.com/ for more info about the products we are building
