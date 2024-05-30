# Powershell Core script to install Jenkins locally
$currentWorkingDir = Get-Location
$jenkinsWar        = "$currentWorkingDir\jenkins\jenkins.war"
$jenkinsWarUrl     = "https://github.com/jenkinsci/jenkins/releases/download/jenkins-2.459/jenkins.war"
$pluginInstallFile = "$currentWorkingDir\casc_configs\plugins.yaml"
$pluginManagerJar  = "$currentWorkingDir\jenkins\jenkins-plugin-manager-2.13.0.jar"
$pluginManagerUrl  = "https://github.com/jenkinsci/plugin-installation-manager-tool/releases/download/2.13.0/jenkins-plugin-manager-2.13.0.jar"

# NOTE: Add 'Machine' scope if you want these to persist; requires Administrator privileges
[System.Environment]::SetEnvironmentVariable('CASC_JENKINS_CONFIG', "$currentWorkingDir\casc_configs")
[System.Environment]::SetEnvironmentVariable('JENKINS_HOME', "$currentWorkingDir\jenkins")
[System.Environment]::SetEnvironmentVariable('PLUGIN_DIR', "$currentWorkingDir\jenkins\plugins")

New-Item -ItemType Directory -Force -Path $env:JENKINS_HOME
Invoke-WebRequest $jenkinsWarUrl -OutFile $jenkinsWar
Invoke-WebRequest $pluginManagerUrl -OutFile $pluginManagerJar

java -jar $pluginManagerJar --war $jenkinsWar --plugin-file $pluginInstallFile
java -D"jenkins.install.runSetupWizard=false" -jar $jenkinsWar
