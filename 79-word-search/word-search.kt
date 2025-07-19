class Solution {
    lateinit var chars: Array<CharArray>
    lateinit var str: String
    var result = false
    fun exist(board: Array<CharArray>, word: String): Boolean {
        chars = board
        str = word

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                go(0, i, j, emptyList())
            }
        }
        return result
    }

    fun go(index: Int, i: Int, j: Int, temp: List<Pair<Int, Int>>) {
        if (result) return
        if (index >= str.length) {
            result = true
            return
        }
        if (i >= chars.size || i < 0) {
            return
        } else {
            if (j >= chars[i].size || j < 0) return
        }
        if (str[index] != chars[i][j]) return
        else {
            for(k in temp) {
                if (k.first == i && k.second == j) {
                    return
                }
            }
            go(index + 1, i + 1, j, temp + (i to j))
            go(index + 1, i - 1, j, temp + (i to j))
            go(index + 1, i, j + 1, temp + (i to j))
            go(index + 1, i, j - 1, temp + (i to j))
        }
    }
}