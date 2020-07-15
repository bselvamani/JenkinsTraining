
job("My-Selenium-Grid-Training-Job") {

    logRotator {
        daysToKeep(30)
    }

    triggers {
        cron("H 4 * * *")
    }

    description()
    keepDependencies(false)

    parameters {
        choiceParam("Grid", ["Remote", "Docker"], "Please select the selenium grid ")
        choiceParam("Browser", ["Chrome", "Firefox"], "Please select the browser")
        choiceParam("Headless", ["True", "False"], "Please select the browser type")
    }

    scm {
        git {
            remote {
                url("https://github.com/bselvamani/SeleniumGridTraining.git")
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
            tasks("clean testNGTest -Dgrid=\${Grid} -Dbrowser=\${Browser} -Dheadless=\${Headless}")
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
