pipeline
{
    agent any

    parameters
    {
    string(name: 'TEXT', defaultValue: '', trim: true)
    }

    stages
    {
        stage('Hello')
        {
            steps
            {
                echo("Hello ${TEXT}")
            }
        }
    }
}
