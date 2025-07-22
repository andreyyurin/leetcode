class Solution {
    lateinit var grid: Array<IntArray>
    var counter = 0
    fun uniquePathsWithObstacles(grid: Array<IntArray>): Int {
        val prices = Array(grid.size) { IntArray(grid[it].size) { 0 }}
        prices[0][0] = 1

        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                val top = if (i - 1 >= 0 && grid[i - 1][j] != 1) {
                    prices[i - 1][j]
                } else 0

                val left = if(j > 0 && grid[i][j - 1] != 1) {
                    prices[i][j - 1]
                } else 0

                if (i == 0 && j == 0) {
                    continue
                } else {
                    prices[i][j] = left + top
                }
            }
        }
        return if (grid[prices.size - 1][prices[0].size - 1] == 1) 0 else 
        prices[prices.size - 1][prices[0].size - 1]
    }
}