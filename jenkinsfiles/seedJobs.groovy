// Job DSL Groovy script that defines the job configuration for the seedJobs Jenkins pipeline
// Initial BRANCH_NAME value is passed in through the Jenkins Configuration as Code YAML file
String BRANCH_NAME = "${BRANCH_NAME}" // Prevents getProperty script approval requirement
multibranchPipelineJob('seedJobs')
{
    branchSources
    {
        branchSource
        {
            source
            {
                fromScm
                {
                    name(BRANCH_NAME)

                    scm
                    {
                        gitSCM
                        {
                            branches
                            {
                                branchSpec
                                {
                                    name(BRANCH_NAME)
                                }
                            }

                            browser {}

                            extensions
                            {
                                sparseCheckoutPaths
                                {
                                    sparseCheckoutPaths
                                    {
                                        sparseCheckoutPath
                                        {
                                            path('jenkinsfiles/seedJobs')
                                        }
                                    }
                                }
                            }

                            gitTool('')

                            userRemoteConfigs
                            {
                                userRemoteConfig
                                {
                                    credentialsId('')
                                    name('jenkins-test')
                                    refspec('')
                                    url('https://github.com/Minreaux/jenkins-test.git')
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    factory
    {
        workflowBranchProjectFactory
        {
            scriptPath('jenkinsfiles/seedJobs')
        }
    }
}
