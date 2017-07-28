import groovy.sql.Sql
import org.hibernate.SessionFactory

import javax.sql.DataSource

/**
 * Created by VErmilov on 13.02.2017.
 */

class DBSetupCleanup {

    static transactional = false // Why I need this

    SessionFactory sessionFactory // Injected by Spring
    DataSource dataSource // Also injected

    File schemaDump
    Sql sql

    void setup() {
        sql = new Sql(dataSource)
        schemaDump = File.createTempFile("test-database-dump", ".sql") // Java 7 API
        sql.execute("script drop to ${schemaDump.absolutePath}")
    }

    void cleanup() {
        sql.execute("runscript from ${schemaDump.absolutePath}")
        sessionFactory.currentSession.clear()
        schemaDump.delete()
    }

}
