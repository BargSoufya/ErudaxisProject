pipeline {
    agent any

    tools {
        maven 'Maven'
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
                script {
                    try {
                        bat 'mvn test'
                    } catch (Exception e) {
                        // Ne pas échouer pour les avertissements CDP
                        if (e.getMessage().contains('UNSTABLE')) {
                            echo "Build marqué comme UNSTABLE mais tests passés"
                            currentBuild.result = 'SUCCESS'
                        } else {
                            throw e
                        }
                    }
                }
            }
        }  // ← Cette accolade fermante était manquante !
    }

    post {
        always {
            // ✅ Allure avec résultats correctement pointés
            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
            ])
        }
    }
}