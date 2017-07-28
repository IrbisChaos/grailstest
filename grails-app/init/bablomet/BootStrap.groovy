package bablomet

import groovy.sql.Sql

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        log.info("BootStrap Start app")
        loadDbData()
    }

    def sqlScriptListInit = ["/db/MOCK_AUTHENTICATION_USER.sql"
                             ,"/db/MOCK_PRSN.sql"
                             ,"/db/MOCK_ACCOUNT.sql"
                             ,"/db/MOCK_MEMBERSHIP.sql"
                             ,"/db/MOCK_ACC.sql"
    ]
    def sqlListDestroy = [
            "delete from Acc",
            "delete from MEMBERSHIP",
            "delete from ACCOUNT",
            "delete from Prsn",
            "delete from AUTHENTICATION_USER"
    ]

    def loadDbData = {
        def sql = Sql.newInstance(grailsApplication.config.dataSource.url,
                grailsApplication.config.dataSource.username,
                grailsApplication.config.dataSource.password,
                grailsApplication.config.dataSource.driverClassName)
        sqlScriptListInit.each {sql.execute(BootStrap.getResourceAsStream(it).text)}
    }

    def deleteDbData = {
        def sql = Sql.newInstance(grailsApplication.config.dataSource.url,
                grailsApplication.config.dataSource.username,
                grailsApplication.config.dataSource.password,
                grailsApplication.config.dataSource.driverClassName)
        sqlListDestroy.each {sql.execute(it)}
    }

    def destroy = {
        log.info("BootStrap Stop app")
        deleteDbData()
    }
}
