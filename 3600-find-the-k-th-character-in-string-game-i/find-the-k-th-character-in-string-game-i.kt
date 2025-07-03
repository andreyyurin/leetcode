class Solution {
    fun kthCharacter(k: Int): Char {
        var result = "a"
        var length = 1
        while(length < k) {
            var tempLength = 0
            for (i in 0 until length) {
                result += (result[i] + 1)
                tempLength++
                if (tempLength + length >= k) {
                    break
                }
            }
            length += tempLength
        }

        return result[k - 1]
    }
}