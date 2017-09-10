package inventory

import inventory.Currency.GBX

class FiftyPence : Coin(50, GBX) {

    override fun toString(): String {
        return "$denomination${currency.sign}"
    }
}
