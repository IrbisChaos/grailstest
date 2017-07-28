package bablomet

import domain.Base

/**
 * Created by VErmilov on 10.02.2017.
 */
class Card extends Base {
    String no
    String cd
    String codeCVC
    List<NoPart> noPart = new ArrayList<>()
    static class NoPart
    {
        List<String> part
    }
    static constraints = {
        importFrom Base
        no size: 20
        cd size: 0..50
        codeCVC size: 3
        noPart validator: {it.length == fldLen}
    }

    static transients = [ "noPart" ]

    private static final fldLen = 4
}
