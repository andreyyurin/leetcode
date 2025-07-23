class Solution {
    fun runningSum(nums: IntArray): IntArray {
        if (nums.size == 0) return intArrayOf()
        val sums = IntArray(nums.size)
        sums[0] = nums[0]

        for(i in 1 until nums.size) {
            sums[i] = sums[i - 1] + nums[i]
        }
        return sums
    }
}