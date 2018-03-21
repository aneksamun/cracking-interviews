package co.uk.redpixel.vendingmachine.supply

import co.uk.redpixel.vendingmachine.coin.Pack
import kotlin.properties.Delegates

class Packs(stock: Stock) : Inventory<Pack> {

    private val coinPackList: MutableList<Pack> by Delegates.observable(loadFrom(stock)) { _, _, new ->
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

    fun update(index: Int, size: Int) {
        coinPackList[index] = coinPackList[index].copy(size = size)
    }

    private fun loadFrom(stock: Stock): MutableList<Pack> {
        return stock.load().sortedBy { it.coin }.toMutableList()
    }
}
