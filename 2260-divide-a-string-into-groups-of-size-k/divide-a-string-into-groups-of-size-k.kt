class Solution {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val newSize = ceil(s.length / k.toDouble()).toInt()
        
        val result = Array(newSize) { 
            ""
         }

        var temp = 0
        var chars = 0
        for(i in s) {
            result[temp] += i

            if(chars >= k - 1) {
                chars = 0
                temp++
            } else {
                chars++
            }
        }

        if(result[result.size - 1].length < k) {
            val t = k - result[result.size - 1].length
            for (i in 0 until t) {
                result[result.size - 1] = result[result.size - 1] + fill
            }
        }

        return result
    }
}