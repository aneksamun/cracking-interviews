package service

import inventory.Coin

class LimitedInventory : Inventory {

    private val coins = listOf<Coin>()

    override fun iterator(): Iterator<Coin> {
        return coins.iterator()
    }
}