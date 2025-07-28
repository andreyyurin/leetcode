class Solution {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        val temp = Array(image.size) { posI -> IntArray(image[posI].size) { pos ->
                if (image[posI][pos] == 0) {
                    1
                } else {
                    0
                } 
            } 
        }
        
        for(i in 0 until image.size) {
            val k = image[i].size - 1
            for (j in 0 until image[i].size) {
                image[i][j] = temp[i][k - j]
            }
        }
        return image
    }
}