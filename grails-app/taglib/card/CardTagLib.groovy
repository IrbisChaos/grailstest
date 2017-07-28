package card

import domain.Debtor

/**
 * Created by VErmilov on 18.04.2017.
 */
class CardTagLib {

    def actor

    static namespace = "card"

    def ifPatient = { attrs, body ->
        if (actor.actorRole instanceof Debtor) {
            out << body()
        }
    }
}
