class NeighborSum(private val grid: Array<IntArray>) {
    var sum = 0

    fun adjacentSum(value: Int): Int {
        sum = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == value) {
                    adj(i - 1, j, Direction.top)
                    adj(i + 1, j, Direction.bottom)
                    adj(i, j - 1, Direction.left)
                    adj(i, j + 1, Direction.right)
                    
                    return sum
                }
            }
        }
        return 0
    }

    fun diagonalSum(value: Int): Int {
        sum = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == value) {
                    dia(i + 1, j + 1, Direction.top)
                    dia(i + 1, j - 1, Direction.bottom)
                    dia(i - 1, j + 1, Direction.left)
                    dia(i - 1, j - 1, Direction.right)
                    return sum
                }
            }
        }
        return 0
    }

    private fun adj(i: Int, j: Int, dir: Direction) {
        if (i < 0 || i >= grid.size) return
        if (j < 0 || j >= grid[i].size) return
        sum += grid[i][j]
        // when(dir) {
        //     Direction.top -> {
        //         adj(i - 1, j, dir)
        //     }
        //     Direction.bottom -> {
        //         adj(i + 1, j, dir)
        //     }
        //     Direction.left -> {
        //         adj(i, j - 1, dir)
        //     }
        //     Direction.right -> {
        //         adj(i, j + 1, dir)
        //     }
        //}
    }

    private fun dia(i: Int, j: Int, dir: Direction) {
        if (i < 0 || i >= grid.size) return
        if (j < 0 || j >= grid[i].size) return
        sum += grid[i][j]
        // when(dir) {
        //     Direction.top -> {
        //         dia(i - 1, j + 1, dir)
        //     }
        //     Direction.bottom -> {
        //         dia(i + 1, j + 1, dir)
        //     }
        //     Direction.left -> {
        //         dia(i - 1, j - 1, dir)
        //     }
        //     Direction.right -> {
        //         dia(i + 1, j - 1, dir)
        //     }
        // }
    }

    enum class Direction {
        top, bottom, left, right;
    }

}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * var obj = NeighborSum(grid)
 * var param_1 = obj.adjacentSum(value)
 * var param_2 = obj.diagonalSum(value)
 */