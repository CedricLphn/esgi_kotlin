node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv() {
      sh "chmod +x gradlew && ./gradlew sonarqube"
    }
  }
}