class Solution {
    fun convert(s: String, numRows: Int): String {
        val result = ArrayList<String>()

        var row = 0
        var isGo = true

        for (i in s) {
            if(result.size == row) result.add("")
            result[row] += i
            if (row == 0) isGo = true else if (row == numRows - 1) isGo = false
            if (isGo) row++ else row--
        }

        var res = ""
        print(result)
        for(i in 0 until result.size) {
            if (i == 0) res = res + result[i]
            else res = res + "${result[i]}"
        }
        return res
    }
}