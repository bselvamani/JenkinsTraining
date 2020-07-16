
job("My-RestAssured-Training-Job") {

    logRotator {
        daysToKeep(30)
    }

    triggers {
        cron("H 3 * * *")
    }

    description()
    keepDependencies(false)

    scm {
        git {
            remote {
                url("https://github.com/bselvamani/RestAssuredTraining.git")
            }
            branch("*/master")
        }
    }

    disabled(false)
    concurrentBuild(false)

    wrappers {
        preBuildCleanup()
    }

    steps {
        maven {
            goals("mvn clean test -PapiTest ")
            mavenOpts("maven3.6")
        }
    }

    publishers {
        mailer("bright.selvam@gmail.com", false, false)
    }
}