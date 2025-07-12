class Solution {
    private val memo = HashMap<Triple<Int, Int, Int>, Pair<Int, Int>>()

    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        val (a, b) = listOf(firstPlayer, secondPlayer).sorted()
        val (minR, maxR) = dfs(n, a, b)
        return intArrayOf(minR, maxR)
    }

    private fun dfs(n: Int, a: Int, b: Int): Pair<Int, Int> {
        val key = Triple(n, a, b)
        memo[key]?.let { return it }

        if (a + b == n + 1) return 1 to 1

        var l = a
        var r = b
        if (l - 1 > n - r) {
            val temp = n + 1 - l
            l = n + 1 - r
            r = temp
        }

        val nextRound = (n + 1) / 2
        var minRound = n
        var maxRound = 1

        if (r * 2 <= n + 1) {
            val preLeft = l - 1
            val midGap = r - l - 1
            for (i in 0..preLeft) {
                for (j in 0..midGap) {
                    val res = dfs(nextRound, i + 1, i + j + 2)
                    minRound = minOf(minRound, 1 + res.first)
                    maxRound = maxOf(maxRound, 1 + res.second)
                }
            }
        } else {
            val mirrored = n + 1 - r
            val preLeft = l - 1
            val midGap = mirrored - l - 1
            val innerGap = r - mirrored - 1
            for (i in 0..preLeft) {
                for (j in 0..midGap) {
                    val pos1 = i + 1
                    val pos2 = i + j + 1 + (innerGap + 1) / 2 + 1
                    val res = dfs(nextRound, pos1, pos2)
                    minRound = minOf(minRound, 1 + res.first)
                    maxRound = maxOf(maxRound, 1 + res.second)
                }
            }
        }

        memo[key] = minRound to maxRound
        return memo[key]!!
    }
}