pipeline{
    agent any
    tools{
        maven 'maven 3.9.9'
    }
    stages{
        stage('build mvn'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/delux633/httpweb']])
                bat 'mvn clean install'
            }
        }
        stage('rint dir'){
            steps{
                bat 'dir'
            }
        }
        stage('build docker image'){
            steps{
                bat 'docker build -t httpweb .'
            }
        }
        stage('push image'){
            steps{
                script{
                // withCredentials([string(credentialsId: 'docker3', variable: 'docker3')]) {
                withCredentials([string(credentialsId: 'docker3', variable: 'DOCKER_SECRET')]) {
                        secretValue = DOCKER_SECRET
                bat "docker login -u asadzahid -p ${DOCKER_SECRET}"
                bat 'docker push asadzahid/httpweb'
                }
                //echo "Docker Secret: ${secretValue}"
                }
                }
            }
        }
        }