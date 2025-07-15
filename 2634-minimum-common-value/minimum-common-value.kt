class Solution {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        nums1.sort()
        nums2.sort()
        var j = 0
        var i = 0
        println(nums1.map { it })
        println(nums2.map { it })
        while(true) {
            if (j >= nums2.size || i >= nums1.size) break
            if (nums1[i] == nums2[j]) {
                return nums1[i]
            }

            if (nums1[i] > nums2[j]) {
                j++
            } else {
                i++
            }
        }
        return -1
    }
}