package cli

import com.xenomachina.argparser.ArgParser
import service.LimitedInventory
import service.UnlimitedInventory

class VendingOptions(parser: ArgParser) {
    val inventory by parser.mapping("" +
            "--limited" to LimitedInventory(),
            "--unlimited" to UnlimitedInventory(),
            help = "The inventory limitation option, i.e., whether inventory is limited or not"
    )
}
