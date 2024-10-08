# Jenkins Test
This is used for testing Jenkins Configuration as Code (JCasC), Jenkins Pipeline as Code, Jenkins Plugin Installation Manager Tool, and Jenkins Job DSL functionality.

## Getting Started
Download and install a Java version to your local machine. I recommend installing Eclipse Temurin: https://adoptium.net/installation/. Jenkins currently requires Java 17 or Java 21.
After Java is installed to your local machine, download the repository and run the `Install-Jenkins.ps1` script. This will automatically setup a Jenkins instance locally using configuration as code.

Once setup has finished, you can access the local Jenkins instance through your web browser at http://localhost:8080/.

Mock accounts will be configured automatically and can be used to login. For these accounts, the password is the same as the username:

| User     | Role        |
| -------- | ----------- |
| admin    | FullAdmin   |
| bob      | JobAdmin    |
| bill     | JobAdmin    |
| tim      | JobManager  |
| tom      | JobManager  |
| auto     | ServiceUser |
| jane     | User        |
| john     | User        |

> **_NOTE:_** Jobs are configured to run as the "auto" user by default. Because of this, you must login to the "auto" user once for jobs to work as intended. This is because the "auto" user does not yet exist on first boot, and so jobs are running as "anonmyous" which does not have any permissions. The "auto" user is created after first time login.

> **_NOTE:_** All Jenkins credentials types that are not used in this Jenkins environment have been disabled through the `configs\casc\providers.yaml`.

## With HashiCorp Vault
If you want to run this Jenkins instance with the configured HashiCorp Vault credentials, you must set the `CASC_VAULT_FILE` and `SECRETS_FILE` environment variables to the local path of your `configs\properties\vault.properties` file before running the `Install-Jenkins.ps1` script.

You must also update the following variables in the `vault.properties` file for your Vault server:
- `CASC_VAULT_URL`: Vault server URL
- `CASC_VAULT_PATHS`: Vault kv secret paths that you want Jenkins to be able to access; comma-delimited for multiple paths
- `CASC_VAULT_APPROLE`: Vault AppRole ID
- `CASC_VAULT_APPROLE_SECRET`: Vault AppRole Secret ID
- `CASC_VAULT_ENGINE_VERSION`: Vault kv secret engine version 1 or 2

There are 2 ways to pass secrets to Jenkins from Vault:
1. Vault as a secret source for JCasC: this passes secrets from Vault to Jenkins JCasC on boot through `CASC_VAULT_PATHS` and `CASC_VAULT_FILE`. If these secrets are passed into normal Jenkins credentials types (i.e. secret-text) then these secrets are static. To update these secrets, you must make the change to the secret in Vault and you must restart Jenkins.
2. Vault credentials types: this uses the built-in Vault Jenkins credentials types. These pull the secrets directly from Vault, therefore you need only update the secret in Vault and Jenkins will pull the latest secret from Vault. No Jenkins restart required.

## Cleanup
To restart and test a new Jenkins installation, delete the `jenkins/` directory; when that directory is deleted, the `Install_Jenkins.ps1` script will re-install Jenkins from scratch.
