package calc

import bablomet.Acc

/**
 * Created by VErmilov on 27.04.2017.
 */
class AccountingTransaction {

    private Date date
    private Collection<Entry> entries = new HashSet()
    private boolean wasPosted = false

    AccountingTransaction(Date date) {
        this.date = date
    }

    void add (Money amount, Acc account) {
        if (wasPosted) throw new RuntimeException
                ("Cannot add entry to a transaction that's already posted");
        entries.add(new Entry (amount, date, account, this));
    }

    void post() {
        if (!canPost())
            throw new RuntimeException("Unable to post");
        entries.forEach{
            each -> each.post()
        }
        wasPosted = true;
    }

    boolean canPost(){
        return balance().isZero();
    }

    private Money balance() {
        Money result = Money.rubles(0)
        if (entries.isEmpty()) return result
        entries.forEach{each -> result = result.add(each.amount)}
        result
    }

}
