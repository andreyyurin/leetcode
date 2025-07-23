class Solution {
    lateinit var mat: Array<IntArray>

    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        mat = Array(m) { IntArray(n) { 0 }}

        indices.forEach {
            incRow(it[0])
            incColumn(it[1])
        }

        var ans = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] % 2 != 0) ans ++
            }
        }
        return ans
    }

    fun incRow(i: Int) {
        for(j in 0 until mat[0].size) {
            mat[i][j]++
        }
    }

    fun incColumn(j: Int) {
        for(i in 0 until mat.size) {
            mat[i][j]++
        }
    }
}