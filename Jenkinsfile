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
                  rtUpload (serverId: "aws_artifactory", specPath: '**/*.jar')
                  rtPublishBuildInfo(serverId: 'aws_artifactory')
            }
        }
}
