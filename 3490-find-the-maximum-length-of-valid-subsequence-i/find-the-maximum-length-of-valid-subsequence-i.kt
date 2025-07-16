class Solution {
    lateinit var nums: IntArray
    fun maximumLength(nums: IntArray): Int {

        var (c1, c2, c3) = IntArray(3) { 0 }

        for (num in nums) { if (num%2 == 0) c1++ else c2++ }

        var prev = nums[0]+1

        for (num in nums) { if (num%2 != prev%2) { c3++; prev = num } }
        
        return maxOf(c1, c2, c3)
    }

}