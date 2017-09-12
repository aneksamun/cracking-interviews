package inventory

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

class CoinsAddSpec : Spek({

    describe("add coins to the 50p pack") {
        val pennies = Pack(FiftyPence(), 19)

        on("coins add") {
            val addition = pennies + 1

            it("should increase total size of coins") {
                assertEquals(20, addition.size)
            }
        }
    }

    describe("increase size of 10p coins") {
        var pennies = Pack(TenPence(), 1)

        on("coins increase") {
            pennies++

            it("should increase the size of coins by one") {
                assertEquals(2, pennies.size)
            }
        }
    }
})
