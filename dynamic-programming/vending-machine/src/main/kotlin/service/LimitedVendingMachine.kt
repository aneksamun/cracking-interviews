package service

import coins.Coin
import coins.Pack
import core.VendingMachine

class LimitedVendingMachine(private val packs: List<Pack>) : VendingMachine<Pack> {

    override fun dispense(amount: Int): Sequence<Coin> {
        return sequenceOf()
    }
}
