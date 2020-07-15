package jenkins

import jenkins.model.*;

new File("/Users/NIS1547-mbp/workspace/bselvamani/TrainingProjects/JenkinsTraining/src/main/groovy/seedJob/seed-job-config.xml").withInputStream { Stream ->
    Jenkins.instance.createProjectFromXML("seed", stream)
}

def commands = [
        "mkdir -p /var/jenkins_home/workspace/seed",
        "cp -v /Users/NIS1547-mbp/workspace/bselvamani/TrainingProjects/JenkinsTraining/src/main/groovy/jenkins.jobs/job_selenium_training.groovy /var/jenkins_home/workspace/seed"
]

commands.each {
    def process = it.execute()
    proess.waitFor()
}