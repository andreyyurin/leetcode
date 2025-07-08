class Solution {
    fun multiply(num1: String, num2: String): String {
        val listSum = mutableListOf<String>()
        if (num1 == "0" || num2 == "0") return "0"
        
        for(i in num1.length - 1 downTo 0) {
            var add = 0
            var result = ""
            val f = num1[i].digitToInt()
            for (j in num2.length - 1 downTo 0) {
                val k = num2[j].digitToInt()

                val mul = k * f + add

                result = "${(mul % 10)}$result"
                add = 0
                add += (mul / 10)
            }

            if (add > 0){ 
                result = "$add$result"
            }
            for(j in 0 until num1.length - i - 1) {
                result = "${result}0"
            }
            listSum.add(result)
        }

        var result1 = ""
        for (i in listSum.size - 1 downTo 0) {
            var k = listSum[i].length - 1
            var l = result1.length - 1
            var add = 0

            var newResult = ""
            for(j in max(k, l) downTo 0) {
                var c1 = if (k >= 0) listSum[i][k].digitToInt() else 0
                var c2 = if (l >= 0) result1[l].digitToInt() else 0
                val sum = c1 + c2 + add

                newResult = "${sum % 10}$newResult"
                add = 0
                add += sum / 10

                k--
                l--
            }
            
            if (add > 0){ 
                newResult = "$add$newResult"
            }
            result1 = newResult
        }
        
        return result1
    }
}