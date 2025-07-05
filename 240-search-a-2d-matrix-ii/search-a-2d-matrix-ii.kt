class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix.first().size

        for(i in 0 until m) {
            var left = 0
            var right = n - 1

            var middle = (right + left) / 2

            while(left <= right) {
                middle = (right + left) / 2
                if (matrix[i][middle] == target) {
                    return true
                } else if (target > matrix[i][middle]) {
                    left = middle + 1
                } else {
                    right = middle - 1
                }   
            }
        }
        // var i = 0
        // var j = 0
        // while(left <= right) {
        //     val middle = (right + left) / 2

        //     i = middle / n
        //     j = middle % n

        //     if (matrix[i][j] == target) {
        //         return true
        //     } else if (target > matrix[i][j]) {
        //         left = middle + 1
        //     } else {
        //         right = middle - 1
        //     }
        // }
        return false
    }
}