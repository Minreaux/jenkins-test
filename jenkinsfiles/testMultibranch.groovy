// Job DSL Groovy script that defines the job configuration for the testMultibranch Jenkins pipeline
multibranchPipelineJob('testMultibranch')
{
    branchSources
    {
        branchSource
        {
            source
            {
                fromScm
                {
                    name('setup-job-dsl')

                    scm
                    {
                        gitSCM
                        {
                            branches
                            {
                                branchSpec
                                {
                                    name('setup-job-dsl')
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
                                            path('jenkinsfiles/testMultibranch')
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
            scriptPath('jenkinsfiles/testMultibranch')
        }
    }
}
