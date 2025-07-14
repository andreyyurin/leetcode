class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var j = 0
        var k = 0
        var i = 0
        while(i < g.size && j < s.size) {
            if (s[j] >= g[i]) {
                k++
                i++
                j++
            } else {
                j++
            }
        }   
        return k
    }
}