package authentication

import bablomet.Org
import bablomet.Prsn
import domain.Base

class Membership extends Base {
    String login

    static belongsTo = [prsn: Prsn, org: Org, account: Account]

    static constraints = {
        importFrom Base
        prsn nullable: true
        org nullable: true
    }

    String toString(){
//        "($id) $desc $tsBeg $tsEnd $account $prsn $org"
        "($id) $desc $tsBeg $tsEnd $prsn $org $login $account"
    }

}
