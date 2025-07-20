#!/bin/sh
if [ $(docker ps -a -f name=evaluacionfinal | grep -w evaluacionfinal | wc -l) -eq 1 ]; then
  docker rm -f evaluacionfinal
fi
mvn clean package && docker build -t com.krakedev.moduloii/evaluacionfinal .
docker run -d -p 9080:9080 -p 9443:9443 --name evaluacionfinal com.krakedev.moduloii/evaluacionfinal
