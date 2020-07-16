job("My-TestCafe-Training-Job") {

    logRotator {
        daysToKeep(30)
    }

    triggers {
        cron("H 6 * * *")
    }

    description()
    keepDependencies(false)

    parameters {
        choiceParam("Browser", ["Chrome", "FireFox"], "Please select the browser")
        choiceParam("Headless", ["True", "False"], "Please select the browser type")
    }

    scm {
        git {
            remote {
                url("https://github.com/bselvamani/TestCafeTraining.git")
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
        shell("npm install testcafe test:chrome")
    }

    publishers {
        mailer("bright.selvam@gmail.com", false, false)
    }
}