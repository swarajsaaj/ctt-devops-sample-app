pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK_1.8'
    }
    stages {
	    stage ('Initialize') {
	            steps {
	                sh '''
	                    echo "PATH = ${PATH}"
	                    echo "M2_HOME = ${M2_HOME}"
	                    export BUILD_ID=dontKillMe
	                '''
	            }
	        }
		stage('Checkout') { 
			steps{
			    git "https://github.com/swarajsaaj/ctt-devops-sample-app.git" 
			}
		} 
		stage('Build & Test') {
		    steps{
				sh "mvn clean package" 
				junit '**/target/surefire-reports/*.xml' 
		    }
		}
		stage('Stop, Deploy and Start'){
		 	steps{
		 		// shutdown
			    sh 'curl -X POST http://localhost:10000/shutdown || true'
			    // copy file to target location
			    sh 'cp target/*.jar /tmp/'
			    // start the application
			    sh 'nohup java -jar /tmp/*.jar --server.port=10000 &'
			    // wait for application to respond
			    sh 'while ! curl http://localhost:10000 ; do sleep 1 ; done'
		 	}
		}
    }
}