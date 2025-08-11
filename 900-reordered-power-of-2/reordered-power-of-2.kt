class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val count = count(n)
        return cached.contains(count)
    }

    companion object {
        val cached = HashSet<Int>()

        init {
            for (i in 0 until 30) {
                cached.add(count(1 shl i))
            }
        }
        
        fun count(x: Int): Int {
            var count = 0
            var x = x
            while (x != 0) {
                val digit = x % 10
                count += 1 shl (digit * 3)
                x = x / 10
            }
            return count
        }
    }
}