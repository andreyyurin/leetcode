class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var res = 0
        columnTitle.forEach {
            res = res * 26 + (it - 'A' + 1)
        }
        return res
    }
}