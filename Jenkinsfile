#!groovy

@Library('Roche_pipeline_library@pharma_customer_portal') _

node {

  stage('PreBuild') {
    pre_Build{}
  }
   stage('Build') {
    code_Build{}
  }
  /*stage('Sonar') {
    sonar_Test{}
  } 
  stage('Post Tests') {
    post_Tests{ SITE = "http://192.168.99.1:4502/content/roche-ux/header.ux-preview.html" }
  }
  stage('Speed Tests') {
    speed_Tests{ SITE = "http://192.168.99.1:4502/content/roche-ux/header.ux-preview.html" }
  }*/
}
