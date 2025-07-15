class Solution {
    fun maximum69Number (num: Int): Int {
        val temp = num.toString()
        var res = temp.toCharArray()

        for (i in 0 until temp.length) {
            if (temp[i] == '6') {
                res[i] = '9'
                break
            }
        }
        return String(res).toInt()
    }
}