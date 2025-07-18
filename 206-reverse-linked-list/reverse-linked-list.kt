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

    var temp:ListNode? = null
    fun reverseList(head: ListNode?): ListNode? {
        var temp = head
        var reverse: ListNode? = null
        while(temp != null) {
            var t = temp.next
            temp.next = reverse
            reverse = temp
            temp = t
        }
        return reverse
    }

}