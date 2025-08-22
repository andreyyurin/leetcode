class Solution {
    fun minimumArea(grid: Array<IntArray>): Int {
        var left = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        var up = Int.MAX_VALUE
        var down = Int.MIN_VALUE
        for(i in grid.indices){
            for(j in grid[i].indices){
                if(grid[i][j] == 1){
                    left = minOf(left, j)
                    right = maxOf(right, j)
                    up = minOf(up, i)
                    down = maxOf(down, i)
                }
            }
        }
        return (right - left + 1) * (down - up + 1)
    }
}