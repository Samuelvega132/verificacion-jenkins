pipeline {
    agent any

    tools {
        maven 'mavenjenkins' // Debe coincidir con el nombre configurado en Tools de Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Parte 2: Checkout del repositorio
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Parte 2: Build del proyecto y pruebas
                sh 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Parte 2: Análisis con SonarQube
                withSonarQubeEnv('SonarQubeServer') { // Nombre exacto que le diste en System de Jenkins
                    sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                // Parte 2: Validación del Quality Gate
                timeout(time: 2, unit: 'MINUTES') {
                    script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "El código no superó el Quality Gate de SonarQube: ${qg.status}"
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}