class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        val target = nums.reduce { acc, num -> acc or num }

        fun backtrack(index: Int = 0, current: Int = 0): Int {
            if (index == nums.size) return if (current == target) 1 else 0
            return backtrack(index + 1, current) + backtrack(index + 1, current or nums[index])
        }

        return backtrack()
    }
}