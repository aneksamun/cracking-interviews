package coins

abstract class Coin protected constructor(val denomination: Int, val currency: Currency) : Comparable<Coin> {

    override fun compareTo(other: Coin): Int {
        val p = Pack(FivePence(), 5)

        return this.denomination.compareTo(other.denomination)
    }
}
