class Solution {
    fun findPeakElement(nums: IntArray): Int {
        
        var l = 0
        var r = nums.size - 1

        while(l <= r) {
            
            val leftL = if (l - 1 >= 0) nums[l - 1] else Int.MIN_VALUE
            val rightL = if (l + 1 < nums.size) nums[l + 1] else Int.MIN_VALUE

            val leftR = if (r - 1 >= 0) nums[r - 1] else Int.MIN_VALUE
            val rightR = if (r + 1 < nums.size) nums[r + 1] else Int.MIN_VALUE

            if (nums[l] > leftL && nums[l] > rightL) return l
            if (nums[r] > leftR && nums[r] > rightR) return r

            l++
            r--
        }

        return 0
    }
}