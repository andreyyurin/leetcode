class Solution {

    private lateinit var dig: String
    private val result = ArrayList<String>()
    fun letterCombinations(digits: String): List<String> {
        dig = digits
        go(digits.length - 1, "")
        return result
    }

    fun go(pos: Int, res: String) {
        if (pos < 0) return
        for(i in dig[pos].letters) {
            if (pos > 0) {
                go(pos - 1, i + res) 
            } else {
                result.add(i + res)
            }
        }
    }

    

    private val Char.letters get() = when(this) {
        '2' -> listOf('a', 'b', 'c')
        '3' -> listOf('d', 'e', 'f')
        '4' -> listOf('g', 'h', 'i')
        '5' -> listOf('j', 'k', 'l')
        '6' -> listOf('m', 'n', 'o')
        '7' -> listOf('p', 'q', 'r', 's')
        '8' -> listOf('t', 'u', 'v')
        '9' -> listOf('w', 'x', 'y', 'z')
        else -> listOf()
    }
}