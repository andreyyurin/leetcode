class Solution {
    fun hammingWeight(n: Int): Int {
        var res = 0
        var temp = n
        while(temp > 0) {
            if(temp % 2 != 0) res++
            temp /= 2
        }
        return res
    }
}