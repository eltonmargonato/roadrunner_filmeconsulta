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
      
         stage ('Gera imagem Docker') {
            steps{
                      script {
                             docker.build("filmeconsulta:${env.BUILD_ID}")
                      }
                 }
           }
      
         stage ('Exporta imagem Docker') {
            steps {
                         sh 'docker save filmeconsulta:'${env.BUILD_ID} ' filmeconsulta.tar'
                   }                
           }      
      
   }
}
