class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rowMem = mutableMapOf<Int, Boolean>()
        val columnMem = mutableMapOf<Int, Boolean>()
        val tempMatrix = mutableListOf<MutableList<String>>()

        for (i in 0 until matrix.size) {
            val temp = mutableListOf<String>()
            for (j in 0 until matrix[i].size) {
                temp.add(matrix[i][j].toString())
            }
            tempMatrix.add(temp)
        }

        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                if (matrix[i][j] == 0) {
                    if(rowMem[i] != true){
                        for (kI in 0 until matrix.size) {
                            tempMatrix[kI][j] = "$"
                        }
                    }
                    if(columnMem[j] != true){
                        for (kJ in 0 until matrix[i].size) {
                            tempMatrix[i][kJ] = "$"
                        }
                    }
                }
            }
        }

        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                if(tempMatrix[i][j] == "$") {
                    matrix[i][j] = 0
                }
            }
        }
    }
}