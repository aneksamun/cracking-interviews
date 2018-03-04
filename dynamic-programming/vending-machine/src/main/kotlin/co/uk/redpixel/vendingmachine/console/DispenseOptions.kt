package co.uk.redpixel.vendingmachine.console

import co.uk.redpixel.vendingmachine.supply.Inventory
import co.uk.redpixel.vendingmachine.supply.LimitedInventory
import co.uk.redpixel.vendingmachine.supply.PropertyStock
import co.uk.redpixel.vendingmachine.supply.UnlimitedInventory
import com.xenomachina.argparser.ArgParser

class DispenseOptions(parser: ArgParser) {
    val craftInventory : () -> Inventory by parser.mapping("" +
            "--limited" to { LimitedInventory(PropertyStock) },
            "--unlimited" to { UnlimitedInventory() },
            help = "determines type of inventory being hold by vending machine"
    )
}
