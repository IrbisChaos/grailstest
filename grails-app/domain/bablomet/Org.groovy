package bablomet

import authentication.Membership
import domain.Subj

class Org extends Subj {

    static constraints = {
        importFrom Subj
    }
    static hasMany = [accs: Acc, membership: Membership]
}
