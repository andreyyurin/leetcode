class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        var s = ""
        val result = StringBuilder()
        var canGo = true
        word.forEach {
            if (canGo) s = it + s
            if (!canGo) result.append(it)
            if (it == ch && canGo) {
                result.append(s)
                canGo = false
            }
        }

        return if(canGo) word else result.toString()
    }
}