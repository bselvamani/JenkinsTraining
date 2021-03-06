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
            mavenInstallation("Maven 3.6.3")
            goals("clean test -PapiTest")
        }
    }

    publishers {
        mailer("bright.selvam@gmail.com", false, false)
    }
}