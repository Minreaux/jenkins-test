// Job DSL Groovy script that defines the job configuration for the triggerTest Jenkins pipeline
pipelineJob('triggerTest')
{
    definition
    {
        cpsScm
        {
            scm
            {
                git('https://github.com/Minreaux/jenkins-test.git', 'test-job-dsl')
                scriptPath('jenkinsfiles/triggerTest')
            }
        }
    }
}
