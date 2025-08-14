class Solution {
    fun largestGoodInteger(num: String): String {
        val map = mutableMapOf<Int, Int>()
        var g = 0
        for (i in 1 until num.length) {
           if (num[i] == num[i - 1]) {
            g ++
            if (g == 2) {
                map[num[i - 1].digitToInt()] = 3
            }
           } else {
            if (g == 2) {
                map[num[i - 1].digitToInt()] = 3
            }
            g = 0
           }
        }

        if (g == 2) {
            map[num[num.length - 1].digitToInt()] = 3
        }


        var s = ""
        var k = Int.MIN_VALUE
        for (i in map) {
            if (i.value == 3) {
                k = max(k, i.key)
            }
        }
        return if (k == Int.MIN_VALUE) {
            ""
        } else {
            "$k$k$k"
        }
    }
}