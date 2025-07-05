class Solution {
    lateinit var allGrid: Array<CharArray>
    private var res = 0
    fun numIslands(grid: Array<CharArray>): Int {
        allGrid = grid

        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (allGrid[i][j] == '1') {
                    res++
                    go(i, j)
                }
            }
        }
        return res
    }

    fun go(x: Int, y: Int) {
        if (x < 0 || x >= allGrid.size 
        || y < 0 || y >= allGrid[0].size
        || allGrid[x][y] != '1') {
            return
        }

        allGrid[x][y] = '2'
        go(x + 1, y)
        go(x - 1, y)
        go(x, y + 1)
        go(x, y - 1)
    }
}