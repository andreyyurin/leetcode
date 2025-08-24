class Solution {

    val list = mutableListOf<Int>()
    fun longestSubarray(nums: IntArray): Int {
        var k = 0
        nums.forEach {
            if (it == 0) {
                list.add(k)
                k = 0
                list.add(0)
            }
            if (it == 1) {
                k++
            }
        }

        list.add(k)

        if (list.size == 1) return list.first() - 1
        var s = Int.MIN_VALUE

        println(list)
        for (i in 0 until list.size) {
            var l = 0
            if (i + 1 < list.size) {
                l += list[i + 1]
            }
            if (i - 1 >= 0) {
                l += list[i - 1]
            }
            s = max(l, s)
        }

        return s
    }
}