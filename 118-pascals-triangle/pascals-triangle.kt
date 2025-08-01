class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for(i in 0 until numRows) {
            if (i - 1 < 0) {
                result.add(listOf(1))
                continue
            }
            val temp = mutableListOf<Int>()
            for (j in 0 until i + 1) {
                if (j - 1 < 0) {
                    temp.add(1)
                } else if (j == i) {
                    temp.add(1)
                } else {
                    temp.add(result[i - 1][j] + result[i - 1][j - 1])
                }
            }
            result.add(temp)
        }  
        return result
    }
}