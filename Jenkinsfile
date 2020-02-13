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
      
          stage('Solicita aprovação para fazer deply no Artifactory') {
            // no agent, so executors are not used up when waiting for approvals
            agent none
            steps {
                script {
                    def deploymentDelay = input id: 'Deploy', message: 'Fazer deploy no Artifactory?', submitter: 'rkivisto,admin', parameters: [choice(choices: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24'], description: 'Hours to delay deployment?', name: 'deploymentDelay')]
                    sleep time: deploymentDelay.toInteger(), unit: 'HOURS'
                }
            }
        }

         stage ('Fazer deploy do Jar no Artifactory') {
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
   }
}
