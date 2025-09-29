// Job DSL Groovy script that defines the job configuration for the onePasswordTest Jenkins multibranch pipeline
multibranchPipelineJob('onePasswordTest')
{
    branchSources
    {
        git
        {
            id = 'jenkins-test'
            remote('https://github.com/Minreaux/jenkins-test.git')
        }
    }

    factory
    {
        workflowBranchProjectFactory
        {
            scriptPath('jenkinsfiles/onePasswordTest')
        }
    }

    orphanedItemStrategy
    {
        defaultOrphanedItemStrategy
        {
            abortBuilds(true)
            daysToKeepStr('')
            numToKeepStr('')
            pruneDeadBranches(true)
        }
    }
}
