class Solution {
    fun jump(nums: IntArray): Int {
        val temp = Array<Long>(nums.size, init = { Int.MAX_VALUE.toLong() } )
        var maxJump = 0
        var size = nums.size.toLong()
        temp[0] = 0

        nums.forEachIndexed { index, element ->
            for (i in 1..element) {
                if (index + i < size) {
                    temp[index + i] = min(temp[index] + 1, temp[index + i])
                } else {
                    break
                }
            }
        }

        return temp[nums.size - 1].toInt()
    }
}