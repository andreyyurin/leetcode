class Solution {
    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith(compareBy<IntArray>({ it[0] }, { -it[1] }))
        val n = points.size
        var result = 0

        for (i in 0 until n) {
            val top = points[i][1]
            var bot = Int.MIN_VALUE
            for (j in i + 1 until n) {
                val y = points[j][1]
                if (bot < y && y <= top) {
                    result++
                    bot = y
                    if (bot == top) break
                }
            }
        }
        return result
    }
}