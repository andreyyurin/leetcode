class Solution {
    fun reverseVowels(s: String): String {
        val indexes = mutableListOf<Int>()
        for (i in 0 until s.length) {
            if (isVowel(s[i])) indexes.add(i)
        }

        val temp = StringBuilder(s)
        
        var k = indexes.size - 1
        for (i in 0 until indexes.size) {
            temp[indexes[i]] = s[indexes[k]]
            k--
        }

        return temp.toString()
    }

    private fun isVowel(c: Char): Boolean {
        return when(c) {
            'A' -> true
            'a' -> true
            'E' -> true
            'e' -> true
            'I' -> true
            'i' -> true
            'O' -> true
            'o' -> true
            'U' -> true
            'u' -> true
            else -> false
        }
    }
}