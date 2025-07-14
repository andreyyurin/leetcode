/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    val list = mutableListOf<Int>()
    fun preorder(root: Node?): List<Int> {
        go(root)
        return list
    }

    private fun go(root: Node?) {
        if(root == null) return

        list.add(root!!.`val`)
        for(i in root!!.children) {
            go(i)
        }
    }
}