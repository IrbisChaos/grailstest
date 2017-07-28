package card

import org.springframework.web.servlet.ModelAndView

/**
 * Created by VErmilov on 14.03.2017.
 */
class CardController {
    def actor

    def putmoney = {
        def actor = params.actor
//        log.error("sum:")
//        log.error(sum)
//        actor.actorRole.sum = sum
//        log.error("actor.actorRole.sum:")
//        log.error(actor.actorRole.sum)
        return new ModelAndView("/card/putmoney", [actor: actor])
    }

    def actorMoney = {
        render "<label>Средства зачислены!</label>"
//        def fin = [a:1]
//        return new ModelAndView("/card/approve", [fin: fin])
    }
}
