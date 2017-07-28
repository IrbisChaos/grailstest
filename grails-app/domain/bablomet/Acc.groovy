package bablomet

import domain.Base

class Acc extends Base {
    String debet
    String credit
    Long sum
    String currencyNumCd
    static constraints = {
        importFrom Base
        debet size: 1..26
        credit size: 1..26
        prsn (nullable: true)
        org (nullable: true)
        currencyNumCd size: 3
    }
    Prsn prsn
    Org org
    static belongsTo = [prsn: Prsn, org: Org]
}
