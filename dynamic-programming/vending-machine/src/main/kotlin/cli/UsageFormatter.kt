package cli

import com.xenomachina.argparser.HelpFormatter

class UsageFormatter : HelpFormatter {

    override fun format(progName: String?, columns: Int, values: List<HelpFormatter.Value>): String {
        return "usage: ${progName ?: ""} [-h] (--limited|unlimited)"
    }
}
