class Solution {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val map = mutableMapOf<Char, Boolean>()
        brokenLetters.forEach {
            map[it] = true
        }
        var broken = 0

        var words = text.split(' ')
        for(i in words) {

            var count = true
            for(j in i) {
                if (map[j] == true) {
                    count = false
                    break
                }
            }
            if(count) {
                broken++
            }
        }
        return broken
    }
}