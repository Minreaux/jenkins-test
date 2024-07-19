# Jenkins Test
This is used for testing Jenkins Configuration as Code (JCasC), Jenkins Pipeline as Code, Jenkins Plugin Installation Manager Tool, and Jenkins Job DSL functionality.

## Getting Started
Download the repository and run the `Install-Jenkins.ps1` script. This will automatically setup a Jenkins instance locally using configuration as code.

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

## With 1Password
If you want to run this Jenkins instance with the configured 1Password service account, you must [install the 1Password CLI](https://developer.1password.com/docs/cli/get-started/) on your local machine and set the following environment variables before running the `Install-Jenkins.ps1` script:

- `OP_SERVICE_ACCOUNT_TOKEN`: 1Password service account authentication token used to access your 1Password vault
- `OP_CLI_PATH`: 1Password CLI local install path

> **_NOTE:_** Requires Jenkins secret text credential provider to be enabled.

## With Hashicorp Vault
If you want to run this Jenkins instance with the configured Hashicorp Vault credentials, set the following environment variables before running the `Install-Jenkins.ps1` script:

- `CASC_VAULT_URL`: Vault server URL
- `CASC_VAULT_APPROLE`: Vault AppRole ID
- `CASC_VAULT_APPROLE_SECRET`: Vault AppRole Secret ID
- `CASC_VAULT_ENGINE_VERSION`: Vault kv secret engine version "1" or "2"

> **_NOTE:_** All non-Vault Jenkins credentials types have been disabled for this Jenkins environment except for the Jenkins secret text credential provider which is required for 1Password.

## Cleanup
To restart and test a new Jenkins installation, delete the `jenkins/` directory; when that directory is deleted, the `Install_Jenkins.ps1` script will re-install Jenkins from scratch.
