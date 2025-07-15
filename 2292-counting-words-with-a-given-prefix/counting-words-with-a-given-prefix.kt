class Solution {
    fun prefixCount(words: Array<String>, pref: String): Int {
        var c = 0
        words.forEach {
            if (it.startsWith(pref)) c++
        }
        return c
    }
}