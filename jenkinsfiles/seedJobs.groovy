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
                    name('update-seedJobs')

                    scm
                    {
                        gitSCM
                        {
                            branches
                            {
                                branchSpec
                                {
                                    name('update-seedJobs')
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
                                    name('')
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
