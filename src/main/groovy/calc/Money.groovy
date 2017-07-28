package calc

import org.springframework.util.Assert

import static calc.Money.CurrencyEnum.RUB
import static calc.Money.CurrencyEnum.USD
import static calc.Money.CurrencyEnum.EUR
import static calc.Money.CurrencyEnum.getCurrency

/**
 * Created by VErmilov on 27.04.2017.
 */
class Money implements Comparable<Money> {

    long amount;
    Currency currency = DUMMY_CURRENCY

    static Currency DUMMY_CURRENCY = getCurrency(RUB)

    static enum CurrencyEnum {
        RUB, USD, EUR;
        static Currency getCurrency(CurrencyEnum en) {
            Currency cur = new Currency("RUB", 643, 2)
            switch (en) {
                case(USD): cur = new Currency("USD", 840, 2); break
                case(EUR): cur = new Currency("EUR", 978, 2); break
            }
            cur
        }
    }

    Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = Math.round(amount * centFactor());
    }

    Money(long amount, Currency currency) {
        this.currency = currency;
        this.amount = amount * centFactor();
    }

    Money[] allocate(Long[] ratios) {
        long total = ratios.sum()
        long remainder = amount;
        List<Money> results = new ArrayList<Money>(ratios.length);
        results.forEach{
            ratio ->
                results[i] = newMoney(amount * ratio / total);
                remainder -= ratio.amount
        }
        [0..remainder-1].forEach{
            i -> results[i].amount++
        }
        results;
    }

    private static final Integer[] cents = [1, 10, 100, 1000]
    private int centFactor() {
        cents[currency.getDefaultFractionDigits()];
    }

    BigDecimal amount() {
        BigDecimal.valueOf(amount, currency.getDefaultFractionDigits());
    }

    Money add(Money other) {
        assertSameCurrencyAs(other);
        newMoney(amount + other.amount);
    }

    Money subtract(Money other) {
        assertSameCurrencyAs(other);
        newMoney(amount - other.amount);
    }

    Money multiply(double amount) {
        multiply(new BigDecimal(amount));
    }
    Money multiply(BigDecimal amount) {
        multiply(amount, BigDecimal.ROUND_HALF_EVEN);
    }
    Money multiply(BigDecimal amount, int roundingMode) {
        new Money(amount().multiply(amount), currency, roundingMode);
    }

    private void assertSameCurrencyAs(Money arg) {
        Assert.equals("money math mismatch", currency, arg.currency);
    }
    private Money newMoney(long amount) {
        Money money = new Money();
        money.currency = this.currency;
        money.amount = amount;
        money;
    }

    @Override
    int hashCode() {
        (int) (amount ^ (amount >>> 32))
    }

    @Override
    boolean equals(Object other) {
        (other instanceof Money) && equals((Money)other)
    }

    boolean equals(Money other) {
        currency.equals(other.currency) && (amount == other.amount);
    }


    int compareTo(Object other) {
        compareTo((Money)other);
    }

    @Override
    int compareTo(Money other) {
        assertSameCurrencyAs(other);
        amount - other.amount
    }

    boolean isZero() {
        amount == 0
    }

     static Money dollars(double amount) {
        new Money(amount, getCurrency(USD));
    }

    static Money rubles(double amount) {
        new Money(amount, getCurrency(RUB));
    }

    static Money euro(double amount) {
        new Money(amount, getCurrency(EUR));
    }
    
    static long amountFromView2Db(double amount) {
        amount * cents[DUMMY_CURRENCY.getDefaultFractionDigits()]
    }

    static double amountFromDb2View(long amount) {
        BigDecimal.valueOf(amount)
    }

    static double round(d) {
        BigDecimal.valueOf(d).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue()
    }

}
