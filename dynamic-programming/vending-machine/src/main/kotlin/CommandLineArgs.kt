import com.xenomachina.argparser.ArgParser
import service.Inventory

class CommandLineArgs(parser: ArgParser) {
    val inventory by parser.mapping("" +
            "--limited" to Inventory.LIMITED,
            "--unlimited" to Inventory.UNLIMITED,
            help = "An option describing inventory"
    )
}
