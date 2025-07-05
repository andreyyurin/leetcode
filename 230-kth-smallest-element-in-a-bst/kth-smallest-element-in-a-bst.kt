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

    lateinit var minArray: IntArray

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        val temp = mutableListOf<TreeNode?>()
        var size = 1
        temp.add(root)

        while(size>0){ 
            var curr = temp.first()
            if (curr?.left != null) {
                temp.add(curr?.left)
                size++
            }
            if(curr?.right != null) {
                temp.add(curr?.right)
                size++
            }
            list.add(curr!!.`val`)
            temp.removeAt(0)
            size--
        }
        list.sort()
        return list[k - 1]
    }

    fun go(root: TreeNode?) {
        if (root == null) return
        if (root.`val` < minArray[0]) {
            for (i in minArray.size - 1 downTo 1) {
                minArray[i] = minArray[i - 1]
            }
            minArray[0] = root.`val`
        } else {
            getFillingOfArray(root.`val`)
        }
        go(root?.left)
        go(root?.right)
    }

    fun getFillingOfArray(value: Int) {
        if (minArray.size < 2) return
        for(i in 1 until minArray.size) {
            if (value < minArray[i]) {
                for (j in minArray.size - 1 downTo i + 1) {
                    minArray[i] = minArray[i - 1]
                }
                minArray[i] = value
                break
            }
        }
    }
}