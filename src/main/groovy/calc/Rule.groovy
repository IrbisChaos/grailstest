package calc

/**
 * Created by VErmilov on 26.04.2017.
 */
class Rule {
    static Double sumForward(sum) {
        (sum instanceof String || sum instanceof GString ? Double.valueOf(sum): sum ) / 4
    }
    static Double percentPortion(timeLimit) {
        timeLimit * (1 / 365)
    }

    static Double sumPercentPortion(sum, timeLimit) {
        Money.round(sum * percentPortion(timeLimit))
    }

    static Double sumBack(sum, timeLimit) {
        def sum0 = (sum instanceof String || sum instanceof GString ? Double.valueOf(sum): sum )
        def timeLimit0 = (timeLimit instanceof String || timeLimit instanceof GString ? Double.valueOf(timeLimit): timeLimit )
        Money.round(sum0 * (1 + percentPortion(timeLimit0)))
    }
}
