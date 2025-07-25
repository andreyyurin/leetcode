class Solution {
    fun transformArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var end = nums.size - 1
        var start = 0
        for(i in 0 until nums.size) {
            if (nums[i] % 2 == 0) {
                result[start] = 0
                start++
            } else {
                result[end] = 1
                end--
            }
        }   
        return result
    }
}