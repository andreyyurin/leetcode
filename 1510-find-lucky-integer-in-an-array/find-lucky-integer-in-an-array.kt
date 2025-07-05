class Solution {
    fun findLucky(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        arr.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        var result = Int.MIN_VALUE
        map.forEach {
            if (it.key == it.value && it.key > result) {
                result = it.key
            }
        }

        return if(result == Int.MIN_VALUE) -1 else result
    }
}