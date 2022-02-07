
object MovingAvg {

    /**
     * Given
     *  ns: [1, 2, 3, 4]
     *  window: 4
     *  result: 1 + 2 + 3 + 4 / 4 = 2.5
     *
     * Given:
     *  ns: [1, 2, 3, 4]
     *  window: 2
     *  result: [((1 + 2) / 2) ((2 + 3) / 2) + ((3 + 4) / 2)] = [1.5, 2.5, 3.5]
     */
    fun calculateMovingAvg(ns: List<Int>, window: Int): DoubleArray {
        val movingAvg = DoubleArray((ns.size - window) + 1)

        for (i in movingAvg.indices) {
            movingAvg[i] = ns.subList(i, i + window).sum() / window.toDouble()
        }

        return movingAvg
    }
}
