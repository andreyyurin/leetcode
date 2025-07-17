class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        val map = mutableMapOf<Int, Boolean>()
        val list = mutableListOf<Int>()

        nums.forEach {
            if (map[it] != null) {
                list.add(it)
            } else {
                map[it] = true
            }
        }

        return list
    }
}