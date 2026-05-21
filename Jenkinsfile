pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/BargSoufya/ErudaxisProject.git'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            // Rapport Allure
            allure([
                includeProperties: false,
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'allure-results']]
            ])

            // Rapport Cucumber
            cucumber(
                fileIncludePattern: '**/*.json',
                jsonReportDirectory: 'target/cucumber',
                reportTitle: 'Cucumber Report'
            )
        }
    }
}
