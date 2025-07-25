class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0
        for (i in 0 until s.length - 1) {
            score += abs((s[i] - '0') - (s[i + 1] - '0'))
        }
        return score
    }
}