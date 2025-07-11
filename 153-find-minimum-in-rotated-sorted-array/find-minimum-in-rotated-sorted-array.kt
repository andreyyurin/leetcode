class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        var canGo = true

        var mid = l + (r - l) / 2
        while(l <= r) {
            mid = l + (r - l) / 2
            if (nums[mid] > nums[r]) {
                l = mid + 1
            } else if(nums[mid] > nums[l]){
                r = mid - 1
            } else {
                r--
                l++
            }
        }
        return nums[mid]
    }
}