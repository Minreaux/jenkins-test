// Job DSL Groovy script that defines the job configuration for a seedJobs Jenkins multibranch pipeline
// Initial GIT_URL, BRANCH_NAME, and JENKINSFILE_PATH values are passed in through the jobs.yaml Jenkins Configuration as Code file
// Because this is configured as a Multibranch pipeline, BRANCH_NAME can be used in any other Job DSL scripts that are seeded through this job
multibranchPipelineJob('seedJobs') 
{
    factory {
        workflowBranchProjectFactory 
        {
            scriptPath('C:\\Users\\Jhenna-Rae.Foronda-C\\GitHub\\jenkins-test\\jenkinsfiles\\seedJobs')
        }
    }

    configure {
        it / disabled << 'true'
    }
}