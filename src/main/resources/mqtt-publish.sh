#!/bin/bash
for i in `seq 1 100`;
do
  echo $i
  mosquitto_pub -h localhost -p 8883 -m $i -t temp/random
done 
