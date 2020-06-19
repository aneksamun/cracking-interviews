import kotlin.math.*
import kotlin.random.Random

/**
 * Splits a sequence of the items in separate batches being sized by given number.
 *
 * @param batchSize a size of the items within batch
 * @param items the items to batch
 *
 * Example:
 * totalItems = 11
 * batchSize = 5
 *
 * totalBatches = 11 / 5 = 2.2 ~ 3
 *
 * 1st batch
 * capacity: 5 * 1 = 5
 * pos: max(5 - 11, 0) = 0
 * upperBound: min(5, 11) = 5
 * it = 0; index = 5 - (5 - 0) = 0
 * it = 1; index = 5 - (5 - 1) = 1
 * it = 2; index = 5 - (5 - 2) = 2
 * it = 3; index = 5 - (5 - 3) = 3
 * it = 4; index = 5 - (5 - 4) = 4
 *
 * 2nd batch
 * capacity: 5 * 2 = 10
 * pos: max(10 - 11, 0) = 0
 * upperBound: min(10, 11) = 10
 * it = 0; index = 10 - (5 - 0) = 5
 * it = 1; index = 10 - (5 - 1) = 6
 * it = 2; index = 10 - (5 - 2) = 7
 * it = 3; index = 10 - (5 - 3) = 8
 * it = 4; index = 10 - (5 - 4) = 9
 *
 * 3rd batch
 * capacity: 5 * 3 = 15
 * pos: max(15 - 11, 0) = 4
 * upperBound: min(15, 11) = 11
 * it = 4; index = 11 - (5 - 4) = 10
 */
fun batchItems(batchSize: Int, items: List<Item>) = sequence {

    val totalBatches = ceil(items.size / batchSize.toDouble()).toInt()

    for (currentBatch in 1..totalBatches) {
        val capacity: Int = batchSize * currentBatch
        val pos = max(capacity - items.size, 0)
        val upperBound = min(capacity, items.size)
        val batch = mutableListOf<Item>()

        (pos until batchSize).forEach {
            val index = upperBound - (batchSize - it)
            batch.add(items[index])
        }

        yield(batch)
    }
}

fun test() {
    val batchSize = 5
    val totalItems = batchSize + Random.nextInt(batchSize)
    val items = (0..totalItems).asSequence().map { Item(it + 1) }.toList()

    println("Batch size: $batchSize")
    println("Total items: ${items.size}\n")

    batchItems(batchSize, items).fold(1) { counter, batch ->
        println("Batch #$counter")
        batch.forEach { println(it) }.also { print("\n") }
        counter.inc()
    }
}

data class Item(val id: Int)
