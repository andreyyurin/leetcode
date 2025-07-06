class Solution {
    fun isPalindrome(x: Int): Boolean {
        val cur = x.toString()
        var j = cur.length - 1
        // i j
        // 123321
        for(i in 0 until cur.length) {
            if (i >= j) break
            if (cur[i] != cur[j]) {
                return false
            }
            j --
        }
        return true
    }
}