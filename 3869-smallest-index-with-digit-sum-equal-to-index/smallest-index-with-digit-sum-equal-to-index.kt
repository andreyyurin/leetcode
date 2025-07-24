class Solution {
    fun smallestIndex(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            var k = nums[i]
            var s = 0

            while(k > 0) {
                s += k % 10
                k /= 10
                if (s > i) {
                    break
                }
            }
            if (s == i) return i
        }
        return -1
    }
}