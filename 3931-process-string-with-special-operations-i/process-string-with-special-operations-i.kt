class Solution {
    var result = ""
    fun processStr(s: String): String {
        s.forEach {
            when(it) {
                '*' -> {
                    if (result.isNotEmpty()) {
                        result = result.dropLast(1)
                    }
                }
                '#' -> {
                    result = result + result
                }
                '%' -> {
                    result = result.reversed()
                }
                else -> {
                    result += it
                }
            }
        }
        return result
    }


}