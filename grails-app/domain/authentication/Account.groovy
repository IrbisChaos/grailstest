package authentication

import domain.Subj
import static AccountService.ROLE


class Account extends Subj {
    Integer role
    static constraints = {
        importFrom Subj
        role(inList: getNames(ROLE))
    }

    String toString(){
        "($id) $desc $tsBeg $tsEnd $name $role"
    }

    static List<String> getNames(Class<? extends Enum<?>> e) {
        return Arrays.asList(e.getEnumConstants().replaceAll("^.|.\$", "").split(", "))
    }

    static hasMany = [membership: Membership]
}
