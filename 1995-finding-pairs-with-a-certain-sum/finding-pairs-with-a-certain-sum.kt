class FindSumPairs(val nums1: IntArray, val nums2: IntArray) {

    private val map1 = mutableMapOf<Int, Int>()
    private val map2 = mutableMapOf<Int, Int>()
    init {
        nums1.forEach {
            map1[it] = (map1[it] ?: 0) + 1
        }
        nums2.forEach {
            map2[it] = (map2[it] ?: 0) + 1
        }
    }
    fun add(index: Int, va: Int) {
        map2[nums2[index]] = (map2[nums2[index]] ?: 0) - 1
        nums2[index] = nums2[index] + va
        map2[nums2[index]] = (map2[nums2[index]] ?: 0) + 1
    }

    fun count(tot: Int): Int {
        var k = 0
        map1.forEach {
            if (map2[tot - it.key] != null) {
                k += (it.value * map2[tot - it.key]!!)
            }
        }

        return k
    }

}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = FindSumPairs(nums1, nums2)
 * obj.add(index,`val`)
 * var param_2 = obj.count(tot)
 */