pipeline {
   agent any
 
   stages {

         stage ('Build do projeto') {
              steps {
                         sh 'mvn clean package'
                         junit 'target/**/*.xml'
                    }
           }
      
         stage ('Relatório de cobertura de código') {
              steps {
                        jacoco( 
                            execPattern: 'target/*.exec',
                            classPattern: 'target/classes',
                            sourcePattern: 'src/main/java',
                            exclusionPattern: 'src/test*')
                    }
           }
      
         stage ('Instala novo JAR no Artifactory') {
              steps {
                       rtUpload (serverId: "AWS_Artifactory_ECMO", 
                                 spec: """{ "files": [ {
                                                       "pattern": "target/(*).jar",
                                                       "target": "libs-release/target/{1}.jar"
                                                       }  ] }"""
                                )
                       rtPublishBuildInfo(serverId: 'AWS_Artifactory_ECMO')
                    }
           }      
      
         stage ('Envia email solicitando aprovação para atualizar container') {
            steps {
                  emailext (
                    mimeType: "text/html",
                    subject: "Jenkins aguardando aprovação do Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: "Job aguardando aprovação para publicar container (timeout=1 hora): <p>${env.JOB_NAME} [${env.BUILD_NUMBER}]</p> <br><br> <a href='${env.BUILD_URL}'> ${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>",
                    to: "elton.margonato@terra.com.br" )
                  }
         }      
      
      
         stage ('Aguarda aprovação para atualizar container') {
            steps {
                      timeout(time:1, unit:'HOURS') {
                           input message:'Atualizar container com novo build?', submitter: 'admin'
                      }
                  }
         }      
      
      
         stage ('Gera imagem Docker') {
            steps{
                      script {
                             docker.build("filmeconsulta:latest")
                      }
                 }
           }
      
         stage ('Exporta imagem Docker') {
            steps {
                      sh "docker save -o filmeconsulta.tar filmeconsulta:latest"
                  }                
           }     
      
         stage('Publica Container') {
            steps {
                    ansiblePlaybook(
                          credentialsId: '7240a250-ec80-4f7b-9d50-64d06bf8afb7',
                          inventory: '/etc/ansible/hosts',
                          playbook: '/home/ubuntu/ansible/playbook_roadrunner_filmeconsulta.yml',
                          extraVars: [
                                       jenkins_workspace: "${env.WORKSPACE}"
                                     ])
                  }      
        }   
   }
}
