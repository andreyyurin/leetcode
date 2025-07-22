class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val prices = Array(grid.size) { IntArray(grid[it].size) { Int.MAX_VALUE }}
        prices[0][0] = grid[0][0]

        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                val top = if (i - 1 >= 0) {
                    prices[i - 1][j]
                } else Int.MAX_VALUE

                val left = if(j > 0) {
                    prices[i][j - 1]
                } else Int.MAX_VALUE

                if (i == 0 && j == 0) {
                    continue
                } else {
                    prices[i][j] = grid[i][j] + min(left, top)
                }
            }
        }

        return prices[prices.size - 1][prices[0].size - 1]
    }
}