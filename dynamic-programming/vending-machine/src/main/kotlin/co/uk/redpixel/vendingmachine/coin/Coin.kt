package co.uk.redpixel.vendingmachine.coin

abstract class Coin protected constructor(val denomination: Int, val currency: Currency) : Comparable<Coin> {

    override fun compareTo(other: Coin): Int {
        return this.denomination.compareTo(other.denomination)
    }
}
