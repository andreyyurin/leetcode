class Solution {
    fun firstPalindrome(words: Array<String>): String {
        words.forEach {
            if (it.isPalindrome()) {
                return it
            }
        }
        return ""
    }

    private fun String.isPalindrome(): Boolean {
        var l = 0
        var r = this.length - 1
        while(l <= r) {
            if(l==r) {

            } else {
                if (this[l] != this[r]) return false
            }
            r--
            l++
        }
        return true
    }
}