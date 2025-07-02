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
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return go(root, 0, false)
    }

    fun go(root: TreeNode?, sum: Int, isLeft: Boolean): Int {
        if (root == null) return 0

        val micro = if (isLeft && root?.left == null && root?.right == null) root!!.`val` else 0

        return go(root?.left, micro, true) + go(root?.right, micro, false) + micro
    }
}