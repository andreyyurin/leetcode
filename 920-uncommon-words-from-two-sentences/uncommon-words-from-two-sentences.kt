class Solution {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val map = mutableMapOf<String, Int>()
        val list1 = s1.split(' ')
        list1.forEach {
            if (map[it] == 1) {
                map[it] = 3
            } else if (map[it] != 1 && map[it] != 3) {
                map[it] = 1
            }
        }
        val list2 = s2.split(' ')
        val result = mutableListOf<String>()
        list2.forEach {
            if (map[it] == 1) {
                map[it] = 3
            } else if (map[it] != 1 && map[it] != 3) {
                map[it] = 1
            }
        }
        map.forEach {
            if (it.value == 1) {
                result.add(it.key)
            }
        }
        val array = Array(result.size) { "" }
        result.forEachIndexed { index, item -> array[index] = item }
        println(list1)
        println(list2)
        return array
    }
}