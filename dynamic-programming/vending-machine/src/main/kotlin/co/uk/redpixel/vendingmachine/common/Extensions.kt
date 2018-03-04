package co.uk.redpixel.vendingmachine.common

fun <T> MutableList<T>.addOrUpdate(index: Int, item: T) {
    when {
        size > index -> this[index] = item
        else -> this.add(index, item)
    }
}
