class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        val candyCount = candyType.size

        candyType.forEach {
            map[it] = 0
        }

        val typesCount = map.size

        return if(typesCount > candyCount / 2) {
            candyCount / 2
        } else {
            typesCount
        }

    }
}