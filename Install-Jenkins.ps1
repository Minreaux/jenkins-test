# Powershell Core script to install Jenkins locally
$currentWorkingDir = Get-Location
$cascJenkinsConfig = "$currentWorkingDir\casc_configs"
$jenkinsHome       = "$currentWorkingDir\jenkins"
$jenkinsWar        = "$jenkinsHome\jenkins.war"
$jenkinsWarUrl     = "https://github.com/jenkinsci/jenkins/releases/download/jenkins-2.459/jenkins.war"
$pluginDownloadDir = "$jenkinsHome\plugins"
$pluginInstallFile = "$cascJenkinsConfig\plugins.yaml"
$pluginManagerJar  = "$jenkinsHome\jenkins-plugin-manager-2.13.0.jar"
$pluginManagerUrl  = "https://github.com/jenkinsci/plugin-installation-manager-tool/releases/download/2.13.0/jenkins-plugin-manager-2.13.0.jar"

New-Item -ItemType Directory -Force -Path $jenkinsHome
Invoke-WebRequest $jenkinsWarUrl -OutFile $jenkinsWar
Invoke-WebRequest $pluginManagerUrl -OutFile $pluginManagerJar

java -jar $pluginManagerJar --war $jenkinsWar --plugin-download-directory $pluginDownloadDir --plugin-file $pluginInstallFile
java -D"JENKINS_HOME=$jenkinsHome" -D"jenkins.install.runSetupWizard=false" -D"casc.jenkins.config=$cascJenkinsConfig" -jar $jenkinsWar
