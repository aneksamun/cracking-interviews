package core

import coins.Coin

interface VendingMachine<in T> {
    fun dispense(amount: Int) : Sequence<Coin>
}
