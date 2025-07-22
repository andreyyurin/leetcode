class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var size = columnNumber
        val res = StringBuilder()
        while(size > 0) {
            res.append('A' + (size - 1) % 26)
            size--
            size /= 26
        }
        return res.reverse().toString()
    }
}