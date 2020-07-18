// This script is run as part of initializing Jenkins.
// It creates a seed job and copies the required DSL script to its workspace
import jenkins.model.*

println "Creating seed job"
new File("/usr/share/jenkins/seed-job-config.xml").withInputStream { stream ->
  Jenkins.instance.createProjectFromXML("My-Seed-Job", stream)
}