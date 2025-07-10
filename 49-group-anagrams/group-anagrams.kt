class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<Int, Int>() 
        val result = LinkedList<LinkedList<String>>()
        var mult = IntArray(26,{1})
        val prime = 101

        for (i in 1 until 26) {
            mult[i] = mult[i-1]*prime
        }

        var counter = 0
        for(i in strs) {
            var sum = 0
            for (j in i) {
                sum += mult[(j - 'a')]
            }
            if (map[sum] == null) {
                result.add(LinkedList(listOf(i)))
                map[sum] = counter
                counter++
            } else {
                result[map[sum]!!]?.add(i)
            }
        }
        return result
    }
}