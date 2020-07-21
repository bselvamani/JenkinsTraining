#!/bin/bash

clear

echo "Start my docker jenkins node(Agent)  ..."
java -jar agent.jar -jnlpUrl http://localhost:8080/computer/My-Docker-Jenkins-Agent/slave-agent.jnlp -secret 15c95e98ddf78022aa364d8013bc63b05f194fd4187e6fb9d8f87783f8e574b8 -workDir "/Users/NIS1547-mbp/workspace/Jenkins"