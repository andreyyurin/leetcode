class Solution {
    private val map = mutableMapOf<Int, Boolean>()
    private var temp = 0

    var ans = Int.MAX_VALUE
    fun numSquares(n: Int): Int {
        temp = n

        ans = go(0, 0)

        return ans
    }

    fun go(sum: Int, c: Int): Int {
        if (c >= ans) return Int.MAX_VALUE
        if (sum == temp) {
            ans = min(c, ans)
            return c
        } else if (sum > temp) {
            return Int.MAX_VALUE
        } else {
            val sqr = sqrt(temp.toDouble())
            var tes = Int.MAX_VALUE
            for (i in sqr.toInt() downTo 1) {
                tes = min(go(sum + i * i, c + 1), tes)
            }
            return tes
        }
    }
}