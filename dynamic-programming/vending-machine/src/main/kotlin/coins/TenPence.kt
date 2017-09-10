package coins

import coins.Currency.GBX

class TenPence : Coin(10, GBX) {

    override fun toString(): String {
        return "$denomination${currency.sign}"
    }
}
