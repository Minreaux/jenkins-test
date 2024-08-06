def call(String BRANCH_NAME, String CRON_STRING)
{
    return BRANCH_NAME == 'main' ? CRON_STRING : ''
}
