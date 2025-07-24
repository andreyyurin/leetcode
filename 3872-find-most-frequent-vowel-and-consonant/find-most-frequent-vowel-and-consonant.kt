class Solution {
    fun maxFreqSum(s: String): Int {
        val vowels = mutableMapOf<Char, Int>()
        val cons = mutableMapOf<Char, Int>()

        s.forEach {
            when(it) {
                'a' -> vowels[it] = (vowels[it] ?: 0) + 1
                'e' -> vowels[it] = (vowels[it] ?: 0) + 1
                'i' -> vowels[it] = (vowels[it] ?: 0) + 1
                'o' -> vowels[it] = (vowels[it] ?: 0) + 1
                'u' -> vowels[it] = (vowels[it] ?: 0) + 1
                else -> cons[it] = (cons[it] ?: 0) + 1
            }
        }

        var s1 = Int.MIN_VALUE
        var s2 = Int.MIN_VALUE

        vowels.forEach {
            s1 = max(s1, it.value)
        }

        cons.forEach {
            s2 = max(s2, it.value)
        }
        val k1 = if (s1 == Int.MIN_VALUE) 0 else s1
        val k2 = if (s2 == Int.MIN_VALUE) 0 else s2
        return k1 + k2
    }
}