class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()

        nums2.forEachIndexed { index, item ->
            map[item] = index
        }
        val list = mutableListOf<Int>()
        nums1.forEach {
            if (map[it] == null) {
                list.add(-1)
            } else {
                var ind = map[it]!!
                for(i in map[it]!! + 1 until nums2.size) {
                    if (nums2[i] > it) {
                        ind = i
                        break
                    }
                }

                if(ind == map[it]) {
                    list.add(-1)
                } else {
                    list.add(nums2[ind])
                }
            }
        }
        return IntArray(nums1.size) {
            list[it]
        }
    }
}