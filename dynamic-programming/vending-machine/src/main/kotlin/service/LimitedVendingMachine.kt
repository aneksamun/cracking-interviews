package service

import inventory.Coin
import inventory.Pack

class LimitedVendingMachine(private val packs: List<Pack>) {

    fun dispense(amount: Int): Sequence<Coin> {
        return sequenceOf()
    }
}
