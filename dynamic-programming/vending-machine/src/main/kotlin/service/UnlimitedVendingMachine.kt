package service

import coins.Coin
import core.VendingMachine

class UnlimitedVendingMachine(private val coins: List<Coin>) : VendingMachine<Coin> {

    override fun dispense(amount: Int): Sequence<Coin> {
        return sequenceOf()
    }
}
