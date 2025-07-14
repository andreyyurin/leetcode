/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var curr = head
        var res = ""

        while(curr != null) {
            res = res + curr.`val`.toString()
            curr = curr?.next
        }
        return binaryToDecimalOptimized(res)
    }
    fun binaryToDecimalOptimized(binary: String): Int {
        var result = 0
        
        for (char in binary) {
            result = result shl 1 or (char - '0')
        }
        
        return result
    }
}