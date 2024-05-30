# Powershell Core script to install Jenkins locally
$currentWorkingDir = Get-Location
$jenkinsConfigs    = "$currentWorkingDir\configs"
$jcascConfigs      = "$jenkinsConfigs\casc"
$jenkinsHome       = "$currentWorkingDir\jenkins"
$jenkinsWar        = "$jenkinsHome\jenkins.war"
$jenkinsWarUrl     = "https://github.com/jenkinsci/jenkins/releases/download/jenkins-2.452.1/jenkins.war" # Long-Term Support (LTS) release
$pluginManagerJar  = "$jenkinsHome\jenkins-plugin-manager-2.13.0.jar"
$pluginManagerUrl  = "https://github.com/jenkinsci/plugin-installation-manager-tool/releases/download/2.13.0/jenkins-plugin-manager-2.13.0.jar"
$pluginsConfig     = "$jenkinsConfigs\plugins.yaml"
$pluginsDir        = "$jenkinsHome\plugins"

New-Item -ItemType Directory -Force -Path $jenkinsHome
Invoke-WebRequest $jenkinsWarUrl -OutFile $jenkinsWar
Invoke-WebRequest $pluginManagerUrl -OutFile $pluginManagerJar

java -jar $pluginManagerJar --war $jenkinsWar --plugin-download-directory $pluginsDir --plugin-file $pluginsConfig
java -D"JENKINS_HOME=$jenkinsHome" -D"jenkins.install.runSetupWizard=false" -D"casc.jenkins.config=$jcascConfigs" -jar $jenkinsWar
