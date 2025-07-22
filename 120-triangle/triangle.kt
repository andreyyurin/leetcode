class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val prices = Array(triangle.size) { IntArray(it + 1) { 0 } }
        for(i in 0 until triangle.size) {
            for (j in 0 until triangle[i].size) {
                if (i > 0) {
                    val leftUp = if(j > 0) {
                        prices[i - 1][j - 1]
                    } else {
                        Int.MAX_VALUE
                    }
                    val rightUp = if (j < triangle[i-1].size) {
                        prices[i - 1][j]
                    } else {
                        Int.MAX_VALUE
                    }
                    prices[i][j] = triangle[i][j] + min(leftUp, rightUp)
                } else {
                    prices[i][j] = triangle[i][j]
                }
            }
        }

        var result = Int.MAX_VALUE
            for (j in 0 until triangle[triangle.size - 1].size) {
                result = min(result, prices[triangle.size - 1][j])
            }
        return result
    }
}