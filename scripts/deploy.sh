#!/bin/bash

REPOSITORY=/home/ec2-user/app/step1
PROJECT_NAME=all-dental-clinic-website

echo "> current pid : $CURREN_PID"

if [ -z "$CURRENT_PID" ]; then
        echo "> no running program. do not end"
else
        echo "> kill -15 $CURRENT_PID"
        kill -15 $CURRENT_PID
        sleep 5

fi

echo "> release new application"

JAR_NAME=$(ls $REPOSITORY/ | grep *.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,/home/ec2-user/app/application-oauth.properties \
    $REPOSITORY/$JAR_NAME 2>&1 &

