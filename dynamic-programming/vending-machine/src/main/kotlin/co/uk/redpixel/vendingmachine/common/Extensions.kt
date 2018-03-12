package co.uk.redpixel.vendingmachine.common

fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray> =
        Array(sizeOuter) { IntArray(sizeInner) }
