eventPackagingEnd = {
	depends(compile, parseArguments)

	String group
	//TODO pull in group from config
	if (!args) {
		ant.input addProperty: "pom.group", message: "Enter the groupId",
			defaultvalue: 'com.example'
		group = ant.antProject.properties.'pom.group'
	} else {
		group = args
	}
	group = group?.trim()

	// target location
	pomFile = "${grailsSettings.baseDir}/sonar-pom.xml" //TODO make this config

	// Output the pom.xml
	def pomXML = new File(pomFile).withWriter { writer ->
		def xml = new MarkupBuilder(writer)
		xml.'project'('xmlns': 'http://maven.apache.org/POM/4.0.0',
			'xmlns:xsi': 'http://www.w3.org/2001/XMLSchema-instance',
			'xsi:schemaLocation': 'http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd') {
			modelVersion('4.0.0')
			groupId(group)
			artifactId(metadata.'app.name')
			version(metadata.'app.version')
			packaging('pom')
			name(metadata.'app.name')
			build {

				sourceDirectory('grails-app/controllers,grails-app/services,grails-app/utils,grails-app/domain,grails-app/taglib') //TODO make better

				plugins {
					plugin {
						groupId('org.apache.maven.plugins')
						artifactId('maven-compiler-plugin')
						configuration {
							source('1.6')
							Target('1.6')
							excludes {
								exclude('**/*.*')
							}
						}
					}
					plugin {
						groupId('org.codehaus.mojo')
						artifactId('build-helper-maven-plugin')
						version('1.1')
						executions {
							execution {
								id('add-source')
								phase('generate-sources')
								goals {
									goal('add-source')
								}
								configuration {
									sources {
										source('src/groovy')
										source('src/java')
									}
								}

							}

						}

					}

				}
			}
			properties {
				'sonar.language'('grvy')
				'sonar.dynamicAnalysis'(true)
				'sonar.surefire.reportsPath'('target/test-reports') //TODO make dynamic
				'sonar.cobertura.reportPath'('target/test-reports/cobertura/coverage.xml') //TODO make dynamic
				'sonar.phase'('generate-sources')
			}
		}
	}

	event("StatusFinal", ["POM for Sonar Groovy created: ${pomFile}"])


}
