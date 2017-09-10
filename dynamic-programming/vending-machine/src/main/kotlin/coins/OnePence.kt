package coins

import coins.Currency.GBX

class OnePence : Coin(1, GBX) {

    override fun toString(): String {
        return "$denomination${currency.sign}"
    }
}
