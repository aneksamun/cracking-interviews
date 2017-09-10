package coins

import coins.Currency.GBP

class OnePound : Coin(100, GBP) {

    override fun toString(): String {
        return "${currency.sign}${denomination/100}"
    }
}
