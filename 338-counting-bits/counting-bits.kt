class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)

        for(i in 0..n){
            result[i] = count(i)
        }

        return result
    }

    private fun count(i: Int): Int {
        var res = 0

        var t = i
        while(t > 0) {
            if (t % 2 != 0) {
                res++
            }
            t /= 2
        }

        return res
    }
}