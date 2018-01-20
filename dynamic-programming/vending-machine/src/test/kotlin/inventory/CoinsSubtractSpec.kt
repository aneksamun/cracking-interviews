package inventory

import exception.NotEnoughBalanceException
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CoinsSubtractSpec : Spek({

    describe("subtract coins from the £1 pack") {
        val pounds = Pack(OnePound(), 10)

        on("coins subtract") {
            val remaining = pounds - 3

            it("should reduce total size of coins") {
                assertEquals(7, remaining.size)
            }
        }
    }

    describe("fails to subtract coins") {
        val pennies = Pack(OnePence(), 0)

        on("coins subtract") {
            assertFailsWith<NotEnoughBalanceException> { pennies - 1 }
        }
    }

    describe("decrease size of 20p coins") {
        var pennies = Pack(TwentyPence(), 4)

        on("coins decrease") {
            pennies--

            it("should reduce total size of coins by one") {
                assertEquals(3, pennies.size)
            }
        }
    }

    describe("fails to decrease size of coins") {
        var pennies = Pack(FivePence(), 0)

        on("coins decrease") {
            assertFailsWith<NotEnoughBalanceException> { pennies-- }
        }
    }
})
