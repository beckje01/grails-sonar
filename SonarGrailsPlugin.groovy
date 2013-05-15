class SonarGrailsPlugin {
	def version = "0.1-SNAPSHOT"

	def scopes = [excludes: 'war']
	def grailsVersion = "2.1 > *"

	def pluginExcludes = [
		"grails-app/views/error.gsp",
		"grails-app/conf/mavenInfo.groovy",
		"grails-app/conf/DataSource.groovy",
		"grails-app/conf/Config.groovy",
		"grails-app/conf/UrlMappings.groovy"
	]

	def title = "Sonar Plugin"
	def author = "Jeff Beck"
	def authorEmail = "beckje01@gmail.com"
	def description = '''\
A plugin that provides a script to generate a pom file for use in Sonar.
'''

	def documentation = "https://github.com/beckje01/grails-sonar"
	def license = "APACHE"
	def issueManagement = [system: "github", url: "https://github.com/beckje01/grails-sonar/issues"]
	def scm = [url: "https://github.com/beckje01/grails-sonar"]
}
