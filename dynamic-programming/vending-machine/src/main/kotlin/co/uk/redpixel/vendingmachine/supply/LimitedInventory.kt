package co.uk.redpixel.vendingmachine.supply

import co.uk.redpixel.vendingmachine.coin.Coin
import kotlin.properties.Delegates

class LimitedInventory(stock: Stock) : Inventory {

    private var coinPackList by Delegates.observable(stock.load().sortedBy { it.coin }) { _, _, new ->
        stock.update(new)
    }

    override fun size(): Int {
        return coinPackList.size
    }

    override fun iterator(): Iterator<Coin> {
        return coinPackList.map { it.coin }.iterator()
    }
}
