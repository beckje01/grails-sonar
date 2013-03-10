class SonarGrailsPlugin {
	def version = "0.1-SNAPSHOT"

	def scopes = [excludes: 'war']
	def grailsVersion = "2.1 > *"


	// resources that are excluded from plugin packaging
	def pluginExcludes = [
		"grails-app/views/error.gsp"
	]

	def title = "Sonar Plugin"
	def author = "Jeff Beck"
	def authorEmail = "beckje01@gmail.com"
	def description = '''\
Brief summary/description of the plugin.
'''

	def documentation = "http://grails.org/plugin/sonar"
	def license = "APACHE"
	def issueManagement = [system: "github", url: "https://github.com/beckje01/grails-sonar/issues"]
	def scm = [url: "https://github.com/beckje01/grails-sonar"]
}
