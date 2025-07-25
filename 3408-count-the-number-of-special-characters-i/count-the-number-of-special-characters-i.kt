class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val map = mutableMapOf<Char, Int>()
        var c = 0
        word.forEach {
            if(it.isUpperCase()) {
                val k = it.lowercaseChar()
                if (map[k] != null && map[k] == 1) {
                    map[k] = 3
                    c ++
                } else if (map[k] == null) {
                    map[k] = 2
                }
            } else if (it.isLowerCase()){
                if (map[it] != null && map[it] == 2) {
                    map[it] = 3
                    c ++
                } else if (map[it] == null) {
                    map[it] = 1
                }
            }
        }
        return c
    }
}