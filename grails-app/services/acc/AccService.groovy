package acc

import bablomet.Acc
import calc.Money

/**
 * Created by VErmilov on 27.04.2017.
 */
class AccService {
    def transferMoney (long accountFromID, long accountToID, Money money) {
        Acc accountFrom = Acc.get(accountFromID)
        Acc accountTo = Acc.get(accountToID)
        accountFrom.sum = accountFrom.sum - money.amount
        accountTo.sum = accountTo.sum + money.amount
    }
}
