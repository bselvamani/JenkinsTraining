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
        choiceParam("TestScripts", ["test:chrome", "test:chrome:headless", "test:chrome:iphone", "test:chrome:android", "test:safari"], "Please select the test scripts to execute...")
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
        shell("npm run \${TestScripts}")
    }

    publishers {
        mailer("bright.selvam@gmail.com", false, false)
    }
}