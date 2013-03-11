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
