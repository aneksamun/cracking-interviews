package service

import inventory.Coin

class UnlimitedVendingMachine(private val coins: List<Coin>) {

    fun dispense(amount: Int): Sequence<Coin> {
        return sequenceOf()
    }
}
