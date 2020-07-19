
job("My-Appium-Android-Training-Job") {
    logRotator {
        daysToKeep(30)
    }

    triggers {
        cron("H 1 * * *")
    }

    description()
    keepDependencies(false)

    parameters {
        choiceParam("Application", ["App", "Web"], "")
    }

    disabled(false)
    concurrentBuild(false)

    scm {
        git {
            remote {
                url("https://github.com/bselvamani/AppiumAndroidTraining.git")
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
            tasks("clean build android\${Application}Test")
            gradleName("Gradle 6.5")
            useWrapper(false)
            makeExecutable(false)
            useWorkspaceAsHome(false)
        }
    }

    publishers {
        mailer("bright.selvam@gmail.com", false, false)
    }
}