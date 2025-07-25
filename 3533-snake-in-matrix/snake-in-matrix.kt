class Solution {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        var i = 0
        var j = 0

        commands.forEach {
            when(it) {
                "UP" -> {
                    i -= 1
                }
                "DOWN" -> {
                    i += 1
                }
                "LEFT" -> {
                    j -= 1
                }
                "RIGHT" -> {
                    j += 1
                }
            }
        }
        return (i * n) + j
    }
}