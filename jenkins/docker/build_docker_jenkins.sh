#!/bin/bash

clear

echo "Build my jenkins docker image ..."
docker rm -v my-jenkins
docker build -t my-docker-jenkins .

echo "Run my docker jenkins server  ..."
docker run --name my-jenkins -p 8080:8080 -p 50000:50000 -d my-docker-jenkins
docker run -d -p 8080:8080 -u root -v /var/jenkins_home:/var/jenkins_home jenkins


#docker exec my-jenkins tail -f /usr/share/jenkins/log/jenkins.log
#docker cp my-jenkins:/usr/share/jenkins/log/jenkins.log jenkins.log