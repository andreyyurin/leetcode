class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if(matrix.size == 0) return emptyList()
        if(matrix.size == 1) return matrix[0].toList()

        var i = 0
        var j = 0

        var canGo = true
        var result = LinkedList<Int>()
        var dir = Dir.right
        
        var x = matrix.size
        var y = matrix[0].size

        while(canGo) {
            val topVal = if (i + 1 < x) matrix[i + 1][j] else Int.MAX_VALUE
            val botVal = if (i - 1 >= 0) matrix[i - 1][j] else Int.MAX_VALUE
            val rightVal = if (j + 1 < y) { 
                matrix[i][j + 1]
             } else Int.MAX_VALUE
            
            val leftVal = if (j - 1 > -1) {
                matrix[i][j - 1] 
            } else Int.MAX_VALUE

            if(topVal == Int.MAX_VALUE && botVal == Int.MAX_VALUE && leftVal == Int.MAX_VALUE && rightVal == Int.MAX_VALUE ) {
                result.add(matrix[i][j])
                return result
            }


            if(matrix[i][j] != Int.MAX_VALUE) result.add(matrix[i][j])
            matrix[i][j] = Int.MAX_VALUE

            when(dir) {
                Dir.right -> {
                    if (j + 1 < y && matrix[i][j + 1] != Int.MAX_VALUE) {
                        j++
                    } else {
                        dir = Dir.bottom
                    }
                }
                Dir.bottom -> {
                    if (i + 1 < x && matrix[i + 1][j] != Int.MAX_VALUE) {
                        i++
                    } else {
                        dir = Dir.left
                    }
                }
                Dir.left -> {
                    if (j - 1 >= 0 && matrix[i][j - 1] != Int.MAX_VALUE) {
                        j--
                    } else {
                        dir = Dir.top
                    }
                }
                Dir.top -> {
                    if (i - 1 >= 0 && matrix[i - 1][j] != Int.MAX_VALUE) {
                        i--
                    } else {
                        dir = Dir.right
                    }
                }   
            }
        }
        return result
    }

    enum class Dir {
        left, right, bottom, top
    }
}