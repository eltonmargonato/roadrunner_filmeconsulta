pipeline {
   agent any
 
   tools{
      maven 'Maven 3.6.0'
      jdk 'java-11'
   }
 
   stages {

         stage ('Build do projeto') {
              steps {
                         sh 'mvn clean verify'
                    }
           }

         stage ('Fazer deploy do Jar no Artifactory') {
              steps {
                       rtUpload (serverId: "aws_artifactory", 
                                 spec: """{ "files": [ {
                                                       "pattern": "target/(*).jar",
                                                       "target": "generic-local/{1}.jar"
                                                       }  ] }"""
                                )
                       rtPublishBuildInfo(serverId: 'aws_artifactory')
                    }
           }
   }
}
