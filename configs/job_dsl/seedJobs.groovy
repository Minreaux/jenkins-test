// Job DSL Groovy script that defines the job configuration for the seedJobs Jenkins multibranch pipeline
// Initial REPO_URL, BRANCH_NAME, and JENKINSFILE_PATH values are passed in through the jobs.yaml Jenkins Configuration as Code file
// Because this is configured as a Multibranch pipeline, BRANCH_NAME can be used in any other Job DSL scripts that are seeded through this job
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
                                            path(JENKINSFILE_PATH)
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
                                    url(REPO_URL)
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
            scriptPath(JENKINSFILE_PATH)
        }
    }

    // Disables the seedJobs pipeline initially because it does not work on first time boot; requires automation user setup first
    configure
    {
        it / disabled << 'true'
    }
}
