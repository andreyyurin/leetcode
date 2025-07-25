class Solution {
    fun transformArray(nums: IntArray): IntArray {
        for(i in 0 until nums.size) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0
            } else {
                nums[i] = 1
            }
        }   
        nums.sort()
        return nums
    }
}