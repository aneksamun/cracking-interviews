package co.uk.redpixel.vendingmachine.supply

import co.uk.redpixel.vendingmachine.coin.*

interface Inventory : Iterable<Coin> {
    fun size(): Int
}
