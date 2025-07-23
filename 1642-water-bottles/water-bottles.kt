class Solution {
    var res = 0
    var numExchange: Int = 0
    var free = 0
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        this.numExchange = numExchange
        go(numBottles)
        return res
    }

    fun go(n: Int) {
        res += n
        if (n + free >= numExchange) {
            val k = (n + free) / numExchange
            free = (n + free) % numExchange
            go(k)
        }
    }
}