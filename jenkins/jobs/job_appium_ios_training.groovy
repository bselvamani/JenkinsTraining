
job("My-Appium-IOS-Training-Job") {
    logRotator {
        daysToKeep(30)
    }

    triggers {
        cron("H 2 * * *")
    }

    description()
    keepDependencies(false)

    parameters {
        choiceParam("Application", ["App", "Web"], "Please select the application")
    }

    disabled(false)
    concurrentBuild(false)

    scm {
        git {
            remote {
                url("https://github.com/bselvamani/AppiumIOSTraining.git")
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
        gradle {
            tasks("clean ios${Application}Test")
            gradleName("gradle3.5")
            useWrapper(false)
            makeExecutable(false)
            useWorkspaceAsHome(false)
        }
    }

    publishers {
        mailer("bright.selvam@gmail.com", false, false)
    }
}