pipeline {
   agent any
 
   tools{
      maven 'Maven 3.6.0'
      jdk 'java-11'
   }
 
   stages {
         stage ('Build project') {
              steps {
                         sh 'mvn clean verify'
                    }
           }

}
