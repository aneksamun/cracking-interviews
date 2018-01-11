import cli.VendingHelpFormatter
import cli.VendingOptions
import com.xenomachina.argparser.ArgParser
import service.VendingMachine

fun main(args: Array<String>) {
    try {
        val parser = ArgParser(args, helpFormatter = VendingHelpFormatter())
        VendingOptions(parser).run {
            val vendingMachine = VendingMachine(inventory = inventory)
            val amount = readLine()!!.toInt()
            vendingMachine.dispense(amount)
        }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

