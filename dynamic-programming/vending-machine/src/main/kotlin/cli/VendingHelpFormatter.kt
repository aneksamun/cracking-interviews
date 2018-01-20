package cli

import com.xenomachina.argparser.HelpFormatter

class VendingHelpFormatter : HelpFormatter {

    override fun format(progName: String?, columns: Int, values: List<HelpFormatter.Value>): String {
        return Help.on {
            programName = progName!!
            arguments = values
            width = columns
        }
    }

    private class Help private constructor(private val name: String,
                                           private val requiredArgs: List<HelpFormatter.Value>,
                                           private val optionalArgs: List<HelpFormatter.Value>,
                                           private val positionalArgs: List<HelpFormatter.Value>,
                                           private val columns: Int) {

        companion object {
            fun on(init: Builder.() -> Unit): String {
                val help = Builder(init).build()
                return help.toString()
            }
        }

        override fun toString(): String = buildString {
            appendln("usage: $name ")
        }

        class Builder private constructor() {

            lateinit var programName: String
            lateinit var arguments: List<HelpFormatter.Value>

            var width: Int = Int.MAX_VALUE
                set(value) {
                    field = when {
                        value < 0 -> throw IllegalArgumentException("columns must be non-negative")
                        value == 0 -> Int.MAX_VALUE
                        else -> value
                    }
                }

            constructor(init: Builder.() -> Unit) : this() {
                init()
            }

            fun build(): Help {
                val required = mutableListOf<HelpFormatter.Value>()
                val optional = mutableListOf<HelpFormatter.Value>()
                val positional = mutableListOf<HelpFormatter.Value>()

                for (argument in arguments) {
                    when {
                        argument.isPositional -> positional
                        argument.isRequired -> required
                        else -> optional
                    }.add(argument)
                }

                return Help(programName, required, optional, positional, width)
            }
        }
    }
}
