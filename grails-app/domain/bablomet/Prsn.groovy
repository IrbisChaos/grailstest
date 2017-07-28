package bablomet

import authentication.Membership
import authentication.PrsnService
import domain.Subj
import static PrsnService.GENDER

class Prsn extends Subj{
    String fam
    String secName
    String gender
    String email
    String tel
    Passp passp

    static embedded = ['passp']
    static constraints = {
        importFrom Subj

        secName (column: 'secname', size: 0..50, blank:true)
        gender (inlist: getNames(GENDER), maxSize: 1, blank:false)
        email (size: 5..254, blank:false)
        tel (size: 2..50, blank:false)
    }

    static hasMany = [accs: Acc, membership: Membership]


    String toString(){
        "($id) $desc $tsBeg $tsEnd $name $fam $secName $gender $email $tel $passp.pasTp $passp.pasSer $passp.pasNo $passp.pasDt $passp.pasPlGet $passp.pasAdr"
    }

    public static List<String> getNames(Class<? extends Enum<?>> e) {
        return Arrays.asList(e.getEnumConstants().replaceAll("^.|.\$", "").split(", "))
    }
}

class Passp {
    String pasTp
    String pasSer
    String pasNo
    java.sql.Date pasDt
    String pasPlGet
    String pasAdr

    static constraints = {
        pasTp (column: 'pas_tp', size: 2..3, defaultValue: "'$PAS_TP_DEFAULT'")
        pasSer (column: 'pas_ser', size: 2..10, blank:false)
        pasNo (column: 'pas_no', size: 2..10, blank:false)
        pasDt (column: 'pas_dt', type: java.sql.Date, blank:false)
        pasPlGet (column: 'pas_pl_get', size: 1..254, blank:false)
        pasAdr (column: 'pas_adr', size: 1..254, blank:false)
    }

    static final PAS_TP_DEFAULT = "RF"

    String toString(){
        "$pasTp $pasSer $pasNo $pasDt $pasPlGet $pasAdr"
    }
}
