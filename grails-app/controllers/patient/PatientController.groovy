package patient

import calc.Rule
import org.springframework.web.servlet.ModelAndView

/**
 * Created by VErmilov on 28.02.2017.
 */
class PatientController {

    def debtor
    def actor

    def index = {
//        log.debug(debtor?.sumGet)
        actor.actorRole = debtor
        return new ModelAndView("/patient/index", [debtor: debtor])
    }

    def form() {
    }

    def getmoney = {
        def sum = params.sumGet
        log.debug("sum:")
        log.debug(sum)
        debtor.sum = Double.valueOf (sum)
        return new ModelAndView("/patient/getmoney", [debtor: debtor])
    }

    def refillTimeLimit = {
        def timeLimit = params.timeLimit
        render timeLimit
    }

    def recalcSumPercentPortion = {
        log.error("Recount in!!!!!")
        def sumGet = params.sumGet
        log.error("sumGet:")
        log.error(sumGet)
        def timeLimit = params.timeLimit
        log.error("timeLimit:")
        log.error(timeLimit)
        def txtConsist = params.txtConsist
        log.error("txtConsist:")
        log.error(txtConsist)
        def txtRubles = params.txtRubles
        log.error("txtRubles:")
        log.error(txtRubles)
        if (debtor == null) {
            log.error("debtor is null!!!!!")
        }
        debtor.sum = Double.valueOf (sumGet)
        debtor.timeLimit = Double.valueOf (timeLimit)
        render txtConsist + Rule.sumPercentPortion(debtor.sum, debtor.timeLimit) + txtRubles
    }

    def recalcSumBack = {
        log.error("Recount in:")
        def sumGet = params.sumGet
        def timeLimit = params.timeLimit
        def txtRubles = params.txtRubles
        debtor.sum = Double.valueOf (sumGet)
        debtor.timeLimit = Double.valueOf (timeLimit)
        render Rule.sumBack(debtor.sum, debtor.timeLimit) + txtRubles
    }

    def putmoney = {
        def sum = params.sumGet
        def timeLimit = params.timeLimitTxt
        def sumBack = Rule.sumBack(sum, timeLimit)
        actor.actorRole.sum = Double.valueOf (sum)
        actor.actorRole.timeLimit = Double.valueOf (timeLimit)
        actor.actorRole.sumBack = Double.valueOf (sumBack, timeLimit)
        return new ModelAndView("/patient/getmoney", [actor: actor])
    }

}
