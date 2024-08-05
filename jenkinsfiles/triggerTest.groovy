// Job DSL Groovy script that defines the job configuration for the triggerTest Jenkins pipeline
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
}
