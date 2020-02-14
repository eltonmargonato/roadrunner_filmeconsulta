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
      
         stage ('Gera imagem Docker') {
            steps{
                      script {
                             docker.build("FilmeConsulta:${env.BUILD_ID}")
                      }
                 }
           }


      
   }
}
