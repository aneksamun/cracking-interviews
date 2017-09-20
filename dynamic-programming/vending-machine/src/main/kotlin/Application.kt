import cli.CommandLineArgs
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.SystemExitException
import java.io.StringWriter

fun main(args: Array<String>) {
    try {
        CommandLineArgs(ArgParser(args)).run {
            println(inventory)
        }
    } catch (e: SystemExitException) {
        println(StringWriter().apply {
            e.printUserMessage(this, "vending-machine", 60)
        })
    } catch (e: Exception) {
        println("An unhandled error occurred: ${e.message}")
    }
}

