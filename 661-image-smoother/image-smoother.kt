class Solution {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val result = Array<IntArray>(img.size, init = {
            IntArray(img[0].size)
        })
        for (i in 0 until img.size) {
            result[i] = IntArray(img[i].size)
        }

        for (i in 0 until img.size) {
            for (j in 0 until img[i].size) {
                result[i][j] = point(img, i, j)
            }
        }
        return result
    }

    fun point(img: Array<IntArray>, i: Int, j: Int): Int {
        var sum = 0
        var counter = 0
        for (x in i - 1 .. i + 1) {
            for (y in j - 1 .. j + 1) {
                if (x>=0 && y>=0 && x<img.size && y<img[x].size) {
                    sum+=img[x][y]
                    counter++
                }
            }
        }
        return sum/counter
    }
}