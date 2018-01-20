import cli.VendingHelpFormatter
import cli.VendingOptions
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.SystemExitException
import service.VendingMachine
import java.io.StringWriter

fun main(args: Array<String>) {
    try {
        val parser = ArgParser(args, helpFormatter = VendingHelpFormatter())
        VendingOptions(parser).run {
            val vendingMachine = VendingMachine(inventory = inventory)
            val amount = readLine()!!.toInt()
            vendingMachine.dispense(amount)
        }
    } catch (e: SystemExitException) {
        println(StringWriter().apply {
            e.printUserMessage(this, "vending-machine", 60)
        })
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

