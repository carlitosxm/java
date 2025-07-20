@echo off
call mvn clean package
call docker build -t com.krakedev.moduloii/evaluacionfinal .
call docker rm -f evaluacionfinal
call docker run -d -p 9080:9080 -p 9443:9443 --name evaluacionfinal com.krakedev.moduloii/evaluacionfinal