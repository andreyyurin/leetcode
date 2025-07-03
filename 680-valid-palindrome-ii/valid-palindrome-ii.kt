class Solution {
    fun validPalindrome(s: String): Boolean {
        var k = s.length - 1
        var i = 0
        while(i < s.length / 2 + 1) {
            if (s[i] != s[k]) return go(s, i + 1, k) || go(s, i, k - 1) 
            k --
            i++
        }
        return true
    }

    private fun go(s: String, i: Int, k: Int): Boolean {
        var l = i
        var r = k
        while(l < s.length / 2 + 1) {
            if (s[l] != s[r]) return false
            l++
            r--
        }
        return true
    }
}