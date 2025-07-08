class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        val canGo = true
        if (n==0) return false
        var i = 0
        while(canGo) {
            if (3.0.pow(i) > n) return false
            else if (3.0.pow(i) == n.toDouble()) {
                println(i)
                print(3.0.pow(i))
                return true
            }
            i++
        }
        return false
    }
}