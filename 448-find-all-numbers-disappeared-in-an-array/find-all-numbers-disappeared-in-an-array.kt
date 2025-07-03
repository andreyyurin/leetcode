class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val map = mutableMapOf<Int, Boolean>()
        for (i in nums) {
            map[i] = true
        }
        val temp = mutableListOf<Int>()

        for (i in 0 until nums.size) {
            if (map[i + 1] == null) temp.add(i + 1)
        }

        return temp
    }
}