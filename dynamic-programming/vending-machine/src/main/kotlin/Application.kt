import com.xenomachina.argparser.ArgParser

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        val parsedArgs = CommandLineArgs(ArgParser(args))
        println(parsedArgs.inventory)
    }
}
