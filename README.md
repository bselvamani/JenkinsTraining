# JenkinsTraining
Training project for Jenkins job with local and Docker

#Jenkins Doc:
https://javadoc.jenkins-ci.org/

#Ref:
https://code-maze.com/ci-jenkins-docker/
https://medium.com/allenhwkim/getting-started-docker-on-mac-os-x-72c64670464a
https://stackoverflow.com/questions/40240349/access-docker-var-jenkins-home-from-my-mac

# Jenkins - Slave
java -jar agent.jar -jnlpUrl http://localhost:8080/computer/My-Docker-Jenkins-Agent/slave-agent.jnlp -secret 15c95e98ddf78022aa364d8013bc63b05f194fd4187e6fb9d8f87783f8e574b8 -workDir "/Users/NIS1547-mbp/workspace/Jenkins"