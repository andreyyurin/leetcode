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
    var sum = 0
    var low: Int = 0
    var high: Int = 0
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        this.low = low
        this.high = high
        go(root)
        return sum
    }

    fun go(root: TreeNode?) {
        if (root == null) return
        if (root!!.`val` >= low && root!!.`val` <= high) {
            sum += root!!.`val`
        }
        go(root?.left)
        go(root?.right)
    }
}