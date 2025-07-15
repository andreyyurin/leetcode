class Solution {
    fun countOperations(num1: Int, num2: Int): Int {
        var k1 = num1
        var k2 = num2

        var canGo = true
        var oper = 0

        while(canGo) {
            if (k1 <= 0) {
                canGo = false
                break
            }
            if (k2 <= 0) {
                canGo = false
                break
            }
            
            if (k1 >= k2) {
                k1 -= k2
            } else {
                k2 -= k1
            }
            oper++
        }
        return oper
    }
}