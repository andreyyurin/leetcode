/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    val root: TreeNode? = null
    lateinit var nums: IntArray
    val added = mutableListOf<Int>()
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        this.nums = nums
        val result = go(0, nums.size, -1)
        return result
    }

    fun go(start: Int, end: Int, prevMid: Int): TreeNode? {
        val mid = (start + end) / 2
        if (prevMid == mid || start >= end || mid in added) return null
        val root = TreeNode(nums[mid])
        added.add(mid)

        root.right = go(mid, end, mid)
        root.left = go(start, mid, mid)
        return root
    }
}