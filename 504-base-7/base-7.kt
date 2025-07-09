class Solution {
    fun convertToBase7(num: Int): String {
        var k = abs(num)
        var res = ""
        while(k >= 7) {
            res = (k % 7).toString() + res
            k /= 7
        }

        return (if (num < 0) "-" else "") + k + res
    }

}