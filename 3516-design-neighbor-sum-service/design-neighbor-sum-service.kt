class NeighborSum(private val grid: Array<IntArray>) {
    var sum = 0

    private val map = mutableMapOf<Int, Pair<Int, Int>>()
    init {
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                map[grid[i][j]] = i to j
            }
        }
    }

    fun adjacentSum(value: Int): Int {
        sum = 0

        val (i, j) = map[value]!!

        adj(i - 1, j)
        adj(i + 1, j)
        adj(i, j - 1)
        adj(i, j + 1)
                    
        return sum
    }

    fun diagonalSum(value: Int): Int {
        sum = 0

        val (i, j) = map[value]!!

        dia(i + 1, j + 1)
        dia(i + 1, j - 1)
        dia(i - 1, j + 1)
        dia(i - 1, j - 1)

        return sum
    }

    private fun adj(i: Int, j: Int) {
        if (i < 0 || i >= grid.size) return
        if (j < 0 || j >= grid[i].size) return
        sum += grid[i][j]
    }

    private fun dia(i: Int, j: Int) {
        if (i < 0 || i >= grid.size) return
        if (j < 0 || j >= grid[i].size) return
        sum += grid[i][j]
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * var obj = NeighborSum(grid)
 * var param_1 = obj.adjacentSum(value)
 * var param_2 = obj.diagonalSum(value)
 */