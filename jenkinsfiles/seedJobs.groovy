// Job DSL Groovy script that defines the job configuration for the seedJobs Jenkins pipeline
pipelineJob('seedJobs')
{
    definition
    {
        cpsScm
        {
            scm
            {
                git('https://github.com/Minreaux/jenkins-test.git', 'setup-job-dsl')
                scriptPath('jenkinsfiles/seedJobs')
            }
        }
    }
}
