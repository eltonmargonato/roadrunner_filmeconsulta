pipeline {
   agent any
 
   tools{
      maven 'Maven 3.6.0'
      jdk 'java-11'
   }
 
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

         stage ('Envia email solicitando aprovação') {
            steps {
                  emailext (
                    subject: "Jenkins aguardando aprovação do Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: "<p>'${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p> <br><br> <a href='${env.BUILD_URL}'> ${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>",
                    to: "elton.margonato@terra.com.br" )
                  }
         }      
      
      
         stage ('Solicita aprovação para atualizar container com novo build') {
            steps {
                      timeout(time:2, unit:'MINUTES') {
                           input message:'Atualizar container com novo build?', submitter: 'admin'
                      }
                  }
         }
      
        stage ('Dispara job para atualizar Container') {		
            steps {
                      build 'roadrunner_filmeconsulta_configManager'	
                  }
        }  
      
   }
}
