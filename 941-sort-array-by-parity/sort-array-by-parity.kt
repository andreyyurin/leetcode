class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        val t = mutableListOf<Int>()
        val t2 = mutableListOf<Int>()

        nums.forEach {
            if (it % 2 == 0) {
                t.add(it)
            } else {
                t2.add(it)
            }
        }

        return IntArray(nums.size) {
            if (it >= t.size) {
                t2[it - t.size]
            } else {
                t[it]
            }
        }
    }
}