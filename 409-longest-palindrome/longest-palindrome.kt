class Solution {
    fun longestPalindrome(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        s.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        var k = false
        var length = 0
        
        map.forEach {
            if (it.value % 2 != 0) {
                k = true
            }
            length += (it.value - (it.value % 2))
        }

        return length + (if(k) 1 else 0)
    }
}