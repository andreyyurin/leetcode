class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val temp = mutableSetOf<String>()
        for (i in words) {
            for (j in words) {
                if (i != j && i.contains(j)) {
                    temp.add(j)
                } 
            }
        }

        return temp.toList()
    }
}