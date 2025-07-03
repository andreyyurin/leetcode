class Solution {
    fun addStrings(num1: String, num2: String): String {
        var top = num1
        var bot = num2
        if (num1.length < num2.length) {
            top = num2
            bot = num1
        }

        var j = bot.length - 1
        var memory = 0
        var result = ""
        for (i in top.length - 1 downTo 0) {
            val botChar = if (j < 0) {
                0
            } else {
                bot[j] - '0'
            }
            
            val topChar = top[i] - '0'

            val sum = topChar + botChar + memory

            memory = (sum / 10)

            result = "${sum % 10}" + result
            j--
        }

        return if (memory > 0) "$memory$result" else result
    }
}