#!groovy

@Library('Roche_pipeline_library@development') _

node {

  stage('PreBuild') {
    pre_Build{}
  }
  stage('Build') {
    code_Build{}
  }
  stage('Sonar') {
    sonar_Test{}
  }
  /*stage('NexusPublish') {
    maven_Publish{}
  }
  stage('AEM DEploy') {
   aemNexus_Deploy{
      AUTHOR_IP = "172.31.10.79"
	  AUTHOR_IP = "172.31.10.79"
      ARTIFACT_ID = "roche-diagnostics-DCX-OWP-complete-package"
      ARTIFACT_VERSION = "1.1.0-DEV"
      GROUP_ID = "roche.diagnostics.complete"
      USERNAME = "admin"
      PASSWORD = "{AQAAABAAAAAQxJJ6Rut35x5llZLhNOkR0XKD3xaxEGU4qI3VoUQ5RSY=}"
    }
  }
  stage('Post Tests') {
    post_Tests{ SITE = "http://roche-diagnostics.sapient.com" }
  }
  stage('Speed Tests') {
    speed_Tests{ SITE = "http://roche-diagnostics.sapient.com" }
  }*/
}