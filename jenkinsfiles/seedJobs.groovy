// Job DSL Groovy script that defines the job configuration for the seedJobs Jenkins multibranch pipeline
// This overwrites the initial seedJobs config configured by configs/seedJobs.groovy
String BRANCH_NAME      = "${BRANCH_NAME}" // Prevents getProperty script approval requirement
String GIT_URL          = "${GIT_URL}"
String JENKINSFILE_PATH = "${JENKINSFILE_PATH}"
multibranchPipelineJob('seedJobs')
{
    description('This job is used to seed Jenkins jobs through code using Job DSL scripts')

    branchSources
    {
        branchSource
        {
            strategy
            {
                allBranchesSame
                {
                    props
                    {
                        suppressAutomaticTriggering
                        {
                            strategy('NONE')
                            triggeredBranchesRegex('^$')
                        }
                    }
                }
            }

            source
            {
                git
                {
                    remote(GIT_URL)

                    traits
                    {
                        // Required to filter branches
                        gitBranchDiscovery()

                        headRegexFilter
                        {
                            // A Java regular expression to restrict the names
                            regex("${BRANCH_NAME}.*")
                        }

                        sparseCheckoutPaths
                        {
                            extension
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
}
