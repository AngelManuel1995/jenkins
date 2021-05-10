job('Nodejs-job') {
	
	scm {
		git('https://github.com/AngelManuel1995/simple-node-app-ci-cd-example.git') { node ->
			node / gitConfigName('DSL User')
			node / gitConfigEmail('angelmanuel.goez@hotmail.es')
		}
	}

	triggers {
		scm('H/5 * * * *')
	}

	wrappers {
		nodejs('N16.1.0')
	}
	
	steps {
		shell('npm install')
	}

}
