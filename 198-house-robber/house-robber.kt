class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]

        var prices = IntArray(nums.size) { 0 }
        prices[0] = nums[0]
        prices[1] = max(nums[1], nums[0])
        for(i in 2 until nums.size) {
            prices[i] = max(prices[i - 2] + nums[i], prices[i - 1])
        }
        return prices[nums.size - 1]
    }
}