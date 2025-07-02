class Solution {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        for (i in 0 until s.length) {
            if (map[s[i]] != null) map[s[i]] = -1
            else map[s[i]] = i
        }
        for (i in map.values) {
            if (i != -1) return i
        }
        return -1
    }
}