import java.util.*

/**
 * Verifies whether string is balanced, etc, all open and close brackets are present.
 * @param expression The string to verify.
 * @return True if balanced' otherwise not
 */
fun isBalanced(expression: String): Boolean {
    val brackets = Stack<Char>()

    expression.forEach {
        when (it) {
            '{', '[', '(' -> brackets.push(it)
            '}' -> if (brackets.empty() || brackets.pop() != '{') return false
            ']' -> if (brackets.empty() || brackets.pop() != '[') return false
            ')' -> if (brackets.empty() || brackets.pop() != '(') return false
        }
    }

    return brackets.empty()
}

fun testBracketsString() {
    println(isBalanced("{[()]}"))
    println(isBalanced("{[(])}"))
    println(isBalanced("{{[[(())]]}}"))
}
