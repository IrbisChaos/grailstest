package bablomet

import authentication.AuthenticationService
import authentication.AuthenticationUser
import spock.lang.Specification

/**
 * Created by VErmilov on 07.03.2017.
 */
class AuthenticationUserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        def listVals
        def listEtalon = [0,1,2,3]
        when:
        listVals = AuthenticationUser.getVals(AuthenticationService.STATUS)
        then:
        listVals == listEtalon
    }

}
