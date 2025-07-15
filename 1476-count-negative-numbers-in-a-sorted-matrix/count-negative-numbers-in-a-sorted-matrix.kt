class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var c = 0

        grid.forEach {
            it.forEach {
                if (it < 0) c ++
            }
        }
        return c
    }
}