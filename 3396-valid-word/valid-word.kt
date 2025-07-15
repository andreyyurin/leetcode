class Solution {
    fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        if (!word.contains(Regex("^[a-zA-Z0-9]*\$"))) return false

        var con = 0
        var wovel = 0
        for(i in word) {
            when {
                i == 'a' || i == 'A' 
                || i == 'E' || i == 'e' 
                || i == 'I' || i == 'i'
                || i == 'o' || i == 'O' || i == 'U' || i == 'u' -> {
                    wovel += 1
                }
                i.isDigit() -> {

                }
                else -> con += 1
            }
        }
        return con > 0 && wovel > 0
    }
}