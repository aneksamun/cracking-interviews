package cli

import com.xenomachina.argparser.HelpFormatter

class VendingHelpFormatter : HelpFormatter {

    override fun format(progName: String?, columns: Int, values: List<HelpFormatter.Value>): String {

        return buildString {
            append("usage: java -jar vending-machine-1.0.jar (--limited|--unlimited) [-h]")
        }
    }
}
