class Solution {
    fun addBinary(a: String, b: String): String {
        val s1 = a.length
        val s2 = b.length

        val s = max(s1, s2)

        var mem = 0
        var res = ""
        var j = s2 - 1
        var k = s1 - 1
        for (i in s - 1 downTo 0) {
            val first = if (k >= 0) a[k].digitToInt() else {
                0
            }
            val second = if (j >= 0) { b[j].digitToInt() } else {
                0
            }

            if (first + second > 1 && mem > 0) {
                res = '1' + res
            } else if (first + second == 1 && mem > 0) {
                res = '0' + res
            } else if (first + second == 0 && mem > 0) {
                res = '1' + res
                mem--
            } else if (first + second > 1) {
                res = '0' + res
                mem++
            } else if(first + second == 1) {
                res = '1' + res
            } else if (first + second == 0) {
                res = '0' + res
            }
            j--
            k--
        }

        if (mem > 0) {
            res = '1' + res
        }
        return res
    }
}