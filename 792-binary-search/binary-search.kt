class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val mid = l+(r-l)/2
            if (nums[mid] == target) {
                l = mid
                break
            } else if (nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return if (nums[l] == target) {
            l
        } else {
            -1
        }
    }
}