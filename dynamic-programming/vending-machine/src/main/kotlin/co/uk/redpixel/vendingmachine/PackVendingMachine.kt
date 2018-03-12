package co.uk.redpixel.vendingmachine

import co.uk.redpixel.vendingmachine.coin.Coin
import co.uk.redpixel.vendingmachine.common.InsufficientCoinageException
import co.uk.redpixel.vendingmachine.common.array2dOfInt
import co.uk.redpixel.vendingmachine.supply.Packs
import java.util.ArrayList

class PackVendingMachine(private val packs: Packs) : VendingMachine {

    override fun dispense(amount: Int): List<Coin> {

        val table = mutableListOf(0)
        val pennies = mutableListOf<Coin?>(null)
        val backup = array2dOfInt(amount + 1, packs.size())

        for (i in 0 until packs.size())
            backup[0][i] = packs[i].size

        for (denomination in table.size..amount) {
            var totalRequired = Int.MAX_VALUE
            table.add(denomination, totalRequired)

            for (j in 0 until packs.size()) {
                val coin = packs[j].coin

                if (denomination >= coin.denomination &&
                        table[denomination - coin.denomination] < Int.MAX_VALUE &&
                        backup[denomination - coin.denomination][j] > 0) {

                    totalRequired = 1 + table[denomination - coin.denomination]

                    if (table[denomination] > totalRequired) {
                        table[denomination] = totalRequired
                        when {
                            pennies.size > denomination -> pennies[denomination] = coin
                            else -> pennies.add(coin)
                        }
                        backup[denomination][j] = backup[denomination - coin.denomination][j] - 1
                    } else {
                        backup[denomination][j] = backup[denomination - coin.denomination][j]
                    }
                } else if (denomination < coin.denomination) {
                    backup[denomination][j] = backup[0][j]
                }
            }
        }


        if (table[amount] == Int.MAX_VALUE)
            throw InsufficientCoinageException()

        val coins = findOptimalChange(amount, pennies)

        (0 until packs.size()).forEach { i ->
            val pack = packs[i]
            if (coins.contains(pack.coin)) {
                pack.size = backup[amount][i]
            }
        }

        return coins
    }

    private fun findOptimalChange(current: Int, pennies: List<Coin?>): MutableList<Coin> {
        return if (current > 0) {
            val coins = findOptimalChange(current - pennies[current]!!.denomination, pennies)
            coins.add(pennies[current]!!)
            coins
        } else ArrayList()
    }
}
