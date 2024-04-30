pipeline {

	agent {
		label 'maven'
	}

	stages {
		stage('Build Package') {
			steps {
				sh "mvn --version"
				sh "java --version"
				sh "mvn clean package"
				sh "ls -lrt target/DecisionEngine-v1.1.jar"
			}
		}

		

		stage('Build Image') {
			steps {
				timeout(time: 1, unit: 'HOURS'){
				echo "Building image..."
				sh "oc apply -f cicd/build-config.xml"
				sh "oc start-build buildconfig/aksumjava --from-file=target/DecisionEngine-v1.1.jar"
				}
			}
		}

		stage('Deploy Service') {
			steps {
				echo "Deploying service..."
				sh "oc apply -f cicd/deployment.xml"
			}
		}
	}
}
