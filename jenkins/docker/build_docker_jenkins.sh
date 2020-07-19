#!/bin/bash

clear

echo "Docker Login"
docker login

echo "Build my jenkins docker image ..."
docker rm -v my-jenkins
docker build -t my-docker-jenkins .

echo "Run my docker jenkins server  ..."
docker run -d -p 8080:8080 -p 50000:50000 -u root -v jenkins_home:/var/jenkins_home --name my-jenkins my-docker-jenkins:latest

#docker exec my-jenkins tail -f /usr/share/jenkins/jenkins.log
#docker cp my-jenkins:/usr/share/jenkins/jenkins.log jenkins.log

#docker exec -it <container-id> /bin/bash