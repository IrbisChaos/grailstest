package donor

import bablomet.Card
import domain.CharacterRole
import domain.Subj
import org.springframework.web.servlet.ModelAndView

/**
 * Created by VErmilov on 28.02.2017.
 */
class DonorController {
    def creditor
    def actor

    def index = {
        actor.actorRole = creditor
//        log.debug(creditor?.sum)
        return new ModelAndView("/donor/index", [creditor: creditor])
    }

    def form() {
    }

    def putmoney = {
        def sum = params.sum
        actor.actorRole.sum = Double.valueOf (sum)
        return new ModelAndView("/card/putmoney", [actor: actor])
    }

}
