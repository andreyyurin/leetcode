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
    fun hasCycle(head: ListNode?): Boolean {
        var fow = head
        var current = head
        var canGo = true
        while(fow?.next != null && current != null) {
            current = current?.next
            fow = fow?.next?.next

            if(current == fow) {
                return true
            }
        }
        return false
    }
}