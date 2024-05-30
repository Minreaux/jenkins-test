# Powershell Core script to install Jenkins locally
$currentWorkingDir = Get-Location
$cascJenkinsConfig = "$currentWorkingDir\casc_configs"
$jenkinsHome       = "$currentWorkingDir\jenkins"
$jenkinsWar        = "$currentWorkingDir\jenkins\jenkins.war"
$jenkinsWarUrl     = "https://github.com/jenkinsci/jenkins/releases/download/jenkins-2.459/jenkins.war"
$pluginDownloadDir = "$currentWorkingDir\jenkins\plugins"
$pluginInstallFile = "$currentWorkingDir\casc_configs\plugins.yaml"
$pluginManagerJar  = "$currentWorkingDir\jenkins\jenkins-plugin-manager-2.13.0.jar"
$pluginManagerUrl  = "https://github.com/jenkinsci/plugin-installation-manager-tool/releases/download/2.13.0/jenkins-plugin-manager-2.13.0.jar"

New-Item -ItemType Directory -Force -Path $jenkinsHome
Invoke-WebRequest $jenkinsWarUrl -OutFile $jenkinsWar
Invoke-WebRequest $pluginManagerUrl -OutFile $pluginManagerJar

java -jar $pluginManagerJar --war $jenkinsWar --plugin-download-directory $pluginDownloadDir --plugin-file $pluginInstallFile
java -D"JENKINS_HOME=$jenkinsHome" -D"jenkins.install.runSetupWizard=false" -D"casc.jenkins.config=$cascJenkinsConfig" -jar $jenkinsWar
