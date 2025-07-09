class Solution {
    fun judgeCircle(moves: String): Boolean {
        var h = 0
        var v = 0

        for(i in moves) {
            when(i) {
                'L' -> h--
                'R' -> h++
                'U' -> v--
                'D' -> v++
            }
        }
        return v == 0 && h == 0
    }
}