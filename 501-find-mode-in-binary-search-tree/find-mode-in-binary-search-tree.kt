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
    
    fun findMode(root: TreeNode?): IntArray {
        val list = mutableListOf<TreeNode?>()
        val map = mutableMapOf<Int, Int>()
        list.add(root)
        var size = 1
        while(size > 0) {
            val curr = list.first()

            if (curr!!.left != null) {
                list.add(curr!!.left)
                size++
            }
            if (curr!!.right != null) {
                list.add(curr!!.right)
                size++
            }

            map[curr!!.`val`] = (map[curr!!.`val`] ?: 0) + 1
            list.removeAt(0)
            size--
        }

        var result = Int.MIN_VALUE
        map.forEach {
            if (it.value > result) {
                result = it.value
            }
        }
        val res = mutableListOf<Int>()

        map.forEach {
            if (it.value == result) res.add(it.key)
        }
        return res.toIntArray()
    }
}