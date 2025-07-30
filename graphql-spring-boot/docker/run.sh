#!/bin/bash

java -Xshare:on -XX:SharedArchiveFile=$JAVA_HOME/cds/app.jsa -jar app.jar
#java -Xlog:cds -Xshare:on -XX:SharedArchiveFile=$JAVA_HOME/cds/app.jsa -jar app.jar
#java -Xlog:cds -XX:SharedArchiveFile=$JAVA_HOME/cds/app.jsa -jar app.jar