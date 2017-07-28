package domain

import authentication.AuthenticationUser
import bablomet.Acc
import sun.util.calendar.CalendarUtils

import java.sql.Timestamp

/**
 * Created by VErmilov on 10.02.2017.
 */
abstract class Subj extends Base {
    String name
    static constraints = {
        importFrom Base
        name (size: 1..50, blank:false)
    }

}
