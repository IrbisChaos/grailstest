package util

import java.sql.Timestamp

/**
 * Created by VErmilov on 14.03.2017.
 */
class DateUtils {
    public static final Timestamp tsCur = new Timestamp(System.currentTimeMillis())
    public static final Date dtcur = new Date()

    public static final Date dtMax = new Date(9999, 12, 31)
    public static final Date dtMin = new Date(1000, 1, 1)
    public static final Timestamp tsMax = new Timestamp(9999, 12, 31, 23, 59, 59, 9)
    public static final Timestamp tsMin = new Timestamp(1000, 1, 1, 0, 0, 0, 0)
    public static final String dtBegFld = "dtBeg"
    public static final String dtEndFld = "dtEnd"
    public static final String tsBegFld = "tsBeg"
    public static final String tsEndFld = "tsEnd"
}
