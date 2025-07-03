class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()

        nums1.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        nums2.forEach {
            if(map[it] != null && map[it]!! > 0) {
                result.add(it)
                map[it] = (map[it] ?: 0) - 1
            }
        }

        return result.toIntArray()
    }
}