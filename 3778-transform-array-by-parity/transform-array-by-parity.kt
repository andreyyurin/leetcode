class Solution {
    fun transformArray(nums: IntArray): IntArray {
        val even = mutableListOf<Int>()
        val odd = mutableListOf<Int>()
        for(i in 0 until nums.size) {
            if (nums[i] % 2 == 0) {
                even.add(0)
            } else {
                odd.add(1)
            }
        }   
        return (even + odd).toIntArray()
    }
}