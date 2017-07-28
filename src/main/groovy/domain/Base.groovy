package domain

import java.sql.Timestamp

/**
 * Created by VErmilov on 19.92.2917.
 */
abstract class Base {

    Timestamp tsBeg = new Timestamp(System.currentTimeMillis())
    Timestamp tsEnd = TS_MAX_VALUE
    String desc

    static constraints = {
        tsBeg (column: "ts_beg", type: Timestamp, defaultValue: "CURRENT_TIMESTAMP()")
        tsEnd (column: "ts_end", type: Timestamp, defaultValue: "TIMESTAMP '9999-12-31 23:59:59'")
        desc (nullable: true, size: 0..1000)
    }

    static final Timestamp TS_MAX_VALUE = new Timestamp(9999-1900, 11, 31, 23, 59, 59, 999999999)
}
