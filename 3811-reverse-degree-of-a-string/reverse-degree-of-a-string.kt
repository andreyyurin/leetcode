class Solution {
    fun reverseDegree(s: String): Int {
        var su = 0
        s.forEachIndexed { index, item ->
            su += (('z' - item + 1) * (index + 1))
        }

        return su
    }
}