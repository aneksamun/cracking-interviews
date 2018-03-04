package co.uk.redpixel.vendingmachine.common

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

class ListWriteSpec : Spek({

    describe("having element under certain position replaces it with a new value") {
        val items = mutableListOf(0)

        on("update") {
            items.addOrUpdate(0, 1)

            it("should replace an element") {
                assertEquals(items[0], 1)
            }
        }
    }

    describe("add a new element to list") {
        val items = mutableListOf<Int>()

        on("update") {
            items.addOrUpdate(0, 1)

            it("should replace element") {
                assertEquals(items[0], 1)
            }
        }
    }
})
