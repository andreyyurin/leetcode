class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val size = grid.size * grid[0].size
        println("n=${grid.size}; m=${grid[0].size}")
        val shift = k % size 
        val newGrid = Array(grid.size) { i -> IntArray(grid[i].size) { grid[i][it] }}
        println("shift = $shift; k = $k; size = $size")
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
            println("$i $j")
            val iNext = tNext / grid[0].size
            val jNext = tNext % grid[0].size
            newGrid[i][j] = grid[iNext][jNext]
            t++
        }

        return newGrid.map { it.toList() }
    }
}