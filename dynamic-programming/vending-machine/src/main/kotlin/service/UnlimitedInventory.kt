package service

import inventory.Coin

class UnlimitedInventory: Inventory {

    private val coins = listOf<Coin>()

    override fun iterator(): Iterator<Coin> {
        return coins.iterator()
    }
}