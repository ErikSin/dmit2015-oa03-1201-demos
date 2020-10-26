@echo off
call mvn clean package
call docker build -t ca.nait.dmit/dmit2015-jsf-crud-demo .
call docker rm -f dmit2015-jsf-crud-demo
call docker run -d -p 9080:9080 -p 9443:9443 --name dmit2015-jsf-crud-demo ca.nait.dmit/dmit2015-jsf-crud-demo