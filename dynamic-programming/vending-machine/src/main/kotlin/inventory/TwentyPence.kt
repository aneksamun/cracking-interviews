package inventory

import inventory.Currency.GBX

class TwentyPence : Coin(20, GBX) {

    override fun toString(): String {
        return "$denomination${currency.sign}"
    }
}
