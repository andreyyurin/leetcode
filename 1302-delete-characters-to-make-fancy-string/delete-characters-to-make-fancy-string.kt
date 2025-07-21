class Solution {
    fun makeFancyString(s: String): String {
        val res = StringBuilder(s.length)
        var k = 0
        for (i in 0 until s.length) {
            if (i > 0){
                if (s[i] == s[i - 1]) k++
                else k = 0
            }

            if (k == 2) {
                k--
            } else {
                res.append(s[i])
            }
        }

        return res.toString()
    }
}