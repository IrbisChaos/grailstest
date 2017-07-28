package calc

import bablomet.Acc

/**
 * Created by VErmilov on 27.04.2017.
 */
class Entry {

    Money amount
    Date date
    Acc account
    AccountingTransaction trans

    Entry() {

    }

    Entry(Money amount, Date date, Acc account, AccountingTransaction trans) {
        this.amount = amount
        this.date = date
        this.account = account
        this.trans = trans
    }

    void post() {
        // only used by AccountingTransaction
        account.addEntry(this);
    }
}
