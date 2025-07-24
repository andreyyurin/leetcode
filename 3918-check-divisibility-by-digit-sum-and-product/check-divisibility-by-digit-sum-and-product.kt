class Solution {
    fun checkDivisibility(n: Int): Boolean {
        var sum = 0
        var modif = 1

        var k = n
        while(k > 0) {
            sum += (k % 10)
            modif *= (k % 10)
            k /= 10
        }
        return n % (sum + modif) == 0
    }
}