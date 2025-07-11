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
                    if(rowMem[j] != true){
                        for (kI in 0 until matrix.size) {
                            tempMatrix[kI][j] = "$"
                        }
                        rowMem[j] = true
                    }
                    if(columnMem[i] != true){
                        for (kJ in 0 until matrix[i].size) {
                            tempMatrix[i][kJ] = "$"
                        }
                        columnMem[i] = true
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