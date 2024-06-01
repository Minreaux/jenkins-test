// Job DSL Groovy script that defines the job configuration for the testDsl Jenkins pipeline
pipelineJob('testDsl')
{
    definition
    {
        cpsScm
        {
            scm
            {
                git('https://github.com/Minreaux/jenkins-test.git', BRANCH_NAME)
                scriptPath('jenkinsfiles/testDsl')
            }
        }
    }
}
