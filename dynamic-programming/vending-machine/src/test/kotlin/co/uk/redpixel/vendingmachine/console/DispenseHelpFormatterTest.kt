package co.uk.redpixel.vendingmachine.console

import com.xenomachina.argparser.HelpFormatter
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertTrue

class DispenseHelpFormatterTest : Spek({

    describe("print usage") {
        val formatter = DispenseHelpFormatter()

        on("") {
            val text = formatter.format("vending-machine", 100,
                    listOf(HelpFormatter.Value(
                            usages = listOf("--limited", "--unlimited"),
                            isRequired = true,
                            isPositional = false,
                            isRepeating = false,
                            help = "determines type of inventory being hold by vending machine")))

            it("") {
                assertTrue { text ==
                        """usage: vending-machine (--limited|--unlimited)

                            required arguments
                            --limited,    determines type of inventory being hold by vending machine
                            --unlimited
                        """
                     }
            }
        }
    }
})