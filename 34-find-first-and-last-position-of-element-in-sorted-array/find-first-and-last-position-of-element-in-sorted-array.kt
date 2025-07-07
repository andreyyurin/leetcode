class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var l = 0
        var r = nums.size - 1
        while(l <= r) {
            val mid = l + (r - l) / 2
            if (nums[mid] == target) {
                var lk = mid
                var rk = mid
                var canGoL = true
                var canGoR = true
                while(canGoL || canGoR) {
                    if (lk < 0 || nums[lk] != target) {
                        canGoL = false
                    } else {
                        lk--
                    }
                    if (rk == nums.size || nums[rk] != target) {
                        canGoR = false
                    } else {
                        rk++
                    }
                }

                return intArrayOf(lk + 1, rk - 1)
            }
            else if (nums[mid] > target) {
                r = mid - 1
            } else if (nums[mid] < target) {
                l = mid + 1
            } 
        }

        return IntArray(2) { -1 }
    }
}