class Solution {
    fun dominantIndex(nums: IntArray): Int {
        var prevMax = Int.MIN_VALUE
        var currentMax = Int.MIN_VALUE
        var currentIndex = 0

        var res = -1

        for (i in 0 until nums.size) {
            if (nums[i] > currentMax) {
                currentMax = nums[i]
                currentIndex = i
            }
        }

        for (i in 0 until nums.size) {
            if (nums[i] != currentMax && nums[i] * 2 > currentMax) {
                return -1
            }
        }

        return currentIndex
    }
}