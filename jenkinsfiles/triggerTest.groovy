// Job DSL Groovy script that defines the job configuration for the triggerTest Jenkins pipeline
// For triggers to be present after seedJobs applies, the trigger must be present in the Job DSL script, not the pipeline Jenkinsfile
pipelineJob('triggerTest')
{
    definition
    {
        cpsScm
        {
            lightweight(true)

            scm
            {
                scriptPath("jenkinsfiles/triggerTest")

                git
                {
                    branch('test-job-dsl')
                    remote
                    {
                        url('https://github.com/Minreaux/jenkins-test.git')
                    }
                }
            }
        }
    }

    disabled(false)

    properties
    {
        pipelineTriggers
        {
            triggers
            {
                cron
                {
                    // Trigger this job every 1 minute
                    spec('* * * * *')
                }
            }
        }
    }

}
