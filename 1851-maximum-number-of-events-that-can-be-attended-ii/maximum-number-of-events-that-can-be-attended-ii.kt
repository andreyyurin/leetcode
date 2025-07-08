class Solution {
    //чужое решение, переделай
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        val starts = events.map { it[0] }.distinct().sorted()
        val ends = listOf(0) + events.map { it[1] }.distinct().sorted()
        val endsIdx = ends.mapIndexed { i, v -> v to i }.toMap()
        val prev = mutableMapOf<Int, Int>()

        var j = ends.lastIndex
        for (i in starts.indices.reversed()) {
            while (starts[i] <= ends[j]) j--

            prev[starts[i]] = j
        }

        val dp = Array(ends.size + 1) { IntArray(k + 1) }

        for ((start, end, value) in events.sortedBy { it[1] }) {
            val p = prev[start]!!
            val i = endsIdx[end]!!

            for (j in k downTo 1) {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j], dp[p][j - 1] + value)
            }
        }

        return dp.map { it.max()!! }.max()!!
    }
}