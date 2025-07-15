class Solution {
    fun heightChecker(heights: IntArray): Int {
        val temp = heights.sorted()
        var c = 0
        for(i in 0 until heights.size) {
            if (temp[i] != heights[i]) c++
        }
        return c
    }
}