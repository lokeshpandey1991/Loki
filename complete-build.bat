@Echo off
cd roche.pharma.customerportal.ui/roche.pharma.customerportal.ui.clickdummy/src/main/jcr_root/clickdummy
cmd /C npm install
cmd /C npm install -g grunt-cli
cmd /C npm install grunt --save-dev
cmd /C npm install -g bower
cmd /C bower install
cmd /C npm install aemsync -g
cmd /C grunt aem
cd ../../../../../../

cmd /C  mvn enforcer:enforce
cd roche.pharma.customerportal.complete
cmd /C mvn clean install
cd ../