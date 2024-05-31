// Job DSL Groovy script that defines the job configuration for a Jenkins pipeline
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

    factory
    {
        workflowBranchProjectFactory
        {
            scriptPath('jenkinsfiles/helloWorld')
        }
    }
}
