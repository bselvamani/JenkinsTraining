
job("My-Selenium-Training-Job") {

    logRotator {
        daysToKeep(30)
    }

    triggers {
        cron("H 5 * * *")
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
                url("https://github.com/bselvamani/SeleniumTraining.git")
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
            tasks("clean build testNGTest -Dbrowser=\${Browser} -Dheadless=\${Headless}")
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