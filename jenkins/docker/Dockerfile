FROM jenkins/jenkins:lts
LABEL maintainer=bright.selvam@gmail.com

USER root

#RUN mkdir /usr/share/jenkins
RUN chown -R  jenkins:jenkins /usr/share/jenkins

USER jenkins

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
#ENV JAVA_OPTS="-Xmx8192m"
ENV JENKINS_OPTS="--handlerCountMax=100 --logfile=/usr/share/jenkins/jenkins.log"

COPY seed-job-config.xml /usr/share/jenkins/seed-job-config.xml
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt

COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY create-seed-job.groovy /usr/share/jenkins/ref/init.groovy.d/create-seed-job.groovy

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
