import com.xenomachina.argparser.ArgParser

fun main(args: Array<String>) {
    val parsedArgs = CommandLineArgs(ArgParser(args))
    println(parsedArgs.inventory)
}
