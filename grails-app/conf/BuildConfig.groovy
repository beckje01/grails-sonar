grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
	inherits("global") {
	}
	log "warn"
	legacyResolve true // Do this for now current resolve will break many plugins as of March 10 2013
	repositories {
		grailsCentral()

	}
	dependencies {

	}

	plugins {
		build(":tomcat:$grailsVersion",
			":release:2.2.1",
			":rest-client-builder:1.0.3") {
			export = false
		}
	}
}

//<editor-fold desc="Release Plugin External Maven Config">
def mavenConfigFile = new File("${basedir}/grails-app/conf/mavenInfo.groovy")
if (mavenConfigFile.exists()) {
	def slurpedMavenInfo = new ConfigSlurper().parse(mavenConfigFile.toURL())
	slurpedMavenInfo.grails.project.repos.each {k, v ->
		println "Adding maven info for repo $k"
		grails.project.repos."$k" = v
	}
}
else {
	println "No mavenInfo file found."
}
//</editor-fold>