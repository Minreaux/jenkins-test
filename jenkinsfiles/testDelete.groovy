// Job DSL Groovy script that defines the job configuration for the testDelete Jenkins pipeline
pipelineJob('testDelete')
{
    definition
    {
        cpsScm
        {
            scm
            {
                git('https://github.com/Minreaux/jenkins-test.git', 'setup-job-dsl')
                scriptPath('jenkinsfiles/testDelete')
            }
        }
    }
}
