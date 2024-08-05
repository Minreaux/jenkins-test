// Job DSL Groovy script that defines the job configuration for the triggerTest Jenkins pipeline
pipelineJob("triggerTest") 
{
    definition 
    {
        cpsScm 
        {
            scm 
            {
                git 
                {
                    branch('test-job-dsl')
                    lightweight(true)
                    remote 
                    {
                        url('https://github.com/Minreaux/jenkins-test.git')
                    }
                    scriptPath("jenkinsfiles/triggerTest")
                }
            }
        }
    }

    disabled(false)
}
