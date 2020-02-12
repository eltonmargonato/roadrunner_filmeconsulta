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
