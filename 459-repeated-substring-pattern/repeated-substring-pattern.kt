class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        val start = 0
        var end = s.length / 2 + 1
        var temp = ""
        while(end > 0) {
            end = end - 1
            temp = s.substring(start, end)

            if (end == 0 || temp.length == 0) break

            var parts = s.length / temp.length

            if (s.length % temp.length != 0 || s.length % temp.length == 1) continue

            var isValid = true
            for(i in 1 until parts) {
                var startPart = i * temp.length
                var endPart = startPart + temp.length
 
                var k = 0
                for (j in startPart until endPart) {
                    if (temp[k] != s[j]) {
                        isValid = false
                        break
                    }
                    k++
                }
                if(!isValid) break
            }

            if (isValid) return true
        }

        return false

    }

    fun go(start: Int, end: Int, str: String): String {
        var result = ""
        for(i in start until end) {
            result += str[i]
        }
        return result
    }
}