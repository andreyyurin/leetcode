class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val map = mutableMapOf<Int, Boolean>()
        val result = IntArray(2)
        var c = 0

        nums.forEach {
            if (map[it] == null) {
                map[it] = true
            } else {
                result[c] = it
                c++
            }
            if (c == 2) return result
        }   
        return result
    }
}