/**
 * Determines whether string is palindrome, for example, alus & sula.
 * @param s The value to verify
 * @return YES if string is palindrome; otherwise NO
 */
fun isPalindrome(s: String): String {
    return if (isPalindrome("", s)) "YES" else "NO"
}

private fun isPalindrome(prefix: String, s: String): Boolean {
    var found = false
    if (s.isEmpty()) {
        if (prefix == StringBuilder(prefix).reverse().toString()) {
            return true
        }
    } else {
        for (i in 0 until s.length) {
            found = isPalindrome(prefix + s[i], s.substring(0, i) + s.substring(i + 1, s.length))
            if (found) break
        }
    }

    return found
}
