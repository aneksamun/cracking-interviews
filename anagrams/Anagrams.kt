import java.util.*

/**
 * Detects an indices where 'haystack' part has matching 'needle' part anagram.
 * For example:
 * haystack: abbcba
 * needle: ab
 * result: { 0, 4 }
 * Explanation:
 * 0: ab = ab
 * 4: ba = ab (when rotated)
 * @param haystack the source to verify
 * @param needle the value to match
 * @return an indices of anagrams
 */
fun getAnagramIndices(haystack: String, needle: String): List<Int> {
    val indices = arrayListOf<Int>()
    val len = needle.length

    for (i in 0 until haystack.length) {
        val endIndex = i + len
        if (endIndex > haystack.length) {
            break
        }
        val substring = haystack.substring(i, endIndex)
        if (isAnagram(substring, needle)) {
            indices.add(i)
        }
    }

    return indices
}

private fun isAnagram(test: String, origin: String): Boolean {
    return Arrays.equals(test.toCharArray().sortedArray(), origin.toCharArray().sortedArray())
}

fun countCharactersHasBeenRemovedToHaveAnagrams(first: String, second: String): Int {
    val lettersCount = IntArray(26)

    for (ch in first.toCharArray()) {
        lettersCount[ch - 'a']++
    }

    for (ch in second.toCharArray()) {
        lettersCount[ch - 'a']--
    }

    var result = 0

    for (i in lettersCount) {
        result += Math.abs(i)
    }

    return result
}

fun testAnagramIndices() {
    getAnagramIndices("abba", "ba").forEach { x -> println(x) }
    println(countCharactersHasBeenRemovedToHaveAnagrams("abc", "cde"))
}
