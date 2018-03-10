package co.uk.redpixel.vendingmachine.supply

import co.uk.redpixel.vendingmachine.coin.*

class UnlimitedInventory : Inventory {

    private val coins = listOf(
            OnePence(),
            TwoPence(),
            FivePence(),
            TenPence(),
            TwentyPence(),
            FiftyPence(),
            OnePound()
    )

    override fun size(): Int {
        return coins.size
    }

    override fun iterator(): Iterator<Coin> {
        return coins.iterator()
    }
}
