class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var res = 0
        val map = mutableMapOf<Char, Boolean>()
        jewels.forEach { 
            map[it] = true
        }   
        stones.forEach {
            if (map[it] == true) res++
        }
        return res
    }
}