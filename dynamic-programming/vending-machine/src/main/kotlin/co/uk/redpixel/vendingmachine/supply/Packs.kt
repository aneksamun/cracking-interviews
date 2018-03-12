package co.uk.redpixel.vendingmachine.supply

import co.uk.redpixel.vendingmachine.coin.Pack
import kotlin.properties.Delegates

class Packs(stock: Stock) : Inventory<Pack> {

    private var coinPackList by Delegates.observable(stock.load().sortedBy { it.coin }) { _, _, new ->
        stock.update(new)
    }

    override fun get(index: Int): Pack {
        return coinPackList[index]
    }

    override fun size(): Int {
        return coinPackList.size
    }

    override fun iterator(): Iterator<Pack> {
        return coinPackList.iterator()
    }
}
