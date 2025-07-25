class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val size = grid.size * grid[0].size
        val shift = k % size 
        val newGrid = MutableList(grid.size) { MutableList(grid[0].size) { 0 } }
        var t = 0
        if (shift == 0) return grid.map { it.toList() }

        while(t < size) {
            val i = t / grid[0].size
            val j = t % grid[0].size
            val tNext = if (t - shift < 0) {
                size + (t - shift)
            } else {
                t - shift
            }
            val iNext = tNext / grid[0].size
            val jNext = tNext % grid[0].size
            newGrid[i][j] = grid[iNext][jNext]
            t++
        }

        return newGrid
    }
}