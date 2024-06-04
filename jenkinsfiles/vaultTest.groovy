// Job DSL Groovy script that defines the job configuration for the vaultTest Jenkins multibranch pipeline
multibranchPipelineJob('vaultTest')
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
            scriptPath('jenkinsfiles/vaultTest')
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
