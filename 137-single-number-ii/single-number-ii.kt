class Solution {
    fun singleNumber(nums: IntArray): Int {
        nums.sort()

        var c = 1
        for(i in 1 until nums.size) {
            if (nums[i] != nums[i - 1] && c == 1) {
                return nums[i - 1]
            } else if(nums[i] == nums[i - 1]) {
                c++
            } else if(nums[i] != nums[i - 1]) {
                c = 1
            }
        }
        return nums[nums.size - 1]
    }
}