package service

import inventory.Coin

class UnlimitedVendingMachine(private val coins: List<Coin>) {

    fun dispense(amount: Int): Sequence<Coin> {
        if (amount <= 0)
            return emptySequence()

        return sequenceOf()
    }
}
