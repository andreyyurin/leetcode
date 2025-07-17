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
    val map = mutableMapOf<Int, Int>()
    var g: Int = 0
    
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        g = k
        return go(root)
    }

    fun go(root: TreeNode?): Boolean {
        if (root == null) return false
        map[root!!.`val`] = (map[root!!.`val`] ?: 0) + 1

        val res = go(root?.left) || go(root?.right)

        val cur = if(g - root.`val` == root.`val`) {
            map[g - root.`val`] != null && (map[g - root.`val`] ?: 0) - 1 > 0
        } else {
            map[g - root.`val`] != null
        }
        
        return cur || res
    }

}