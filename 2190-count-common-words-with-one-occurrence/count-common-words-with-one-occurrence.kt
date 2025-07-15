class Solution {
    fun countWords(words1: Array<String>, words2: Array<String>): Int {
        
        val map1 = mutableMapOf<String, Int>()
        val map2 = mutableMapOf<String, Int>()

        words1.forEach {
            if (map1[it] != null) {
                map1[it] = -1
            } else {
                map1[it] = 0
            }
        }

        words2.forEach {
            if (map2[it] != null) {
                map2[it] = -1
            } else {
                map2[it] = 0
            }
        }
        var counter = 0
        map2.forEach {
            if (it.value != -1 && map1[it.key] != null && map1[it.key] != -1 ) {
                counter++
            }
        }
        return counter
    }
}