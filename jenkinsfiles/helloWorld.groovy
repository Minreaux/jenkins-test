// Job DSL Groovy script that defines the job configuration for the helloWorld Jenkins pipeline
multibranchPipelineJob('helloWorld')
{
    branchSources
    {
        git
        {
            id = 'jenkins-test'
            remote('https://github.com/Minreaux/jenkins-test.git')
        }
    }

    orphanedItemStrategy
    {
        defaultOrphanedItemStrategy
        {
            pruneDeadBranches(true)
        }
    }

    factory
    {
        workflowBranchProjectFactory
        {
            scriptPath('jenkinsfiles/helloWorld')
        }
    }
}
