package co.uk.redpixel.vendingmachine

import co.uk.redpixel.vendingmachine.coin.Coin
import co.uk.redpixel.vendingmachine.common.addOrUpdate
import co.uk.redpixel.vendingmachine.supply.Inventory
import java.util.*

class VendingMachine(private val inventory: Inventory) {

    private val table = mutableListOf(0)
    private val pennies = mutableListOf<Coin?>(null)

    infix fun dispense(amount: Int): List<Coin> {
        when {
            table.size <= amount ->
                for (denomination in table.size..amount) {
                    var totalRequired = Int.MAX_VALUE
                    table.add(denomination, totalRequired)

                    for (coin in inventory) {
                        if (denomination < coin.denomination)
                            break

                        totalRequired = 1 + table[denomination - coin.denomination]

                        if (table[denomination] > totalRequired) {
                            table[denomination] = totalRequired
                            pennies.addOrUpdate(denomination, coin)
                        }
                    }
                }
        }

        return findOptimalChange(amount)
    }

    private fun findOptimalChange(current: Int): MutableList<Coin> {
        return if (current > 0) {
            val coins = findOptimalChange(current - pennies[current]!!.denomination)
            coins.add(pennies[current]!!)
            coins
        } else ArrayList()
    }
}
