class Solution {
   fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val n = baskets.size
        var N = 1
        while (N < n) N = N shl 1
        val seg = IntArray(N shl 1) { if (it in N until N + n) baskets[it - N] else Int.MIN_VALUE }
        for (i in N - 1 downTo 1) seg[i] = maxOf(seg[i * 2], seg[i * 2 + 1])

        var count = 0
        for (x in fruits) {
            var idx = 1
            if (seg[1] < x) { count++; continue }
            while (idx < N) idx = if (seg[idx * 2] >= x) idx * 2 else idx * 2 + 1
            seg[idx] = Int.MIN_VALUE
            var p = idx
            while (p > 1) {
                p /= 2
                seg[p] = maxOf(seg[p * 2], seg[p * 2 + 1])
            }
        }
        return count
    }
}