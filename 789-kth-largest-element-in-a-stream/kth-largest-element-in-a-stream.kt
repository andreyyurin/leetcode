class KthLargest(
    private val k: Int,
    private val nums: IntArray
) {

    private val temp = IntArray(k) { Int.MIN_VALUE }
    private var size = 0

    init {
        fill()
    }

    private fun fill() {
        nums.sort()
        var j = 0
        val down = if (nums.size - k < 0) 0 else nums.size - k
        for(i in nums.size - 1 downTo down) {
            temp[j] = nums[i]
            j++
            size++
        }
    }

    fun add(`val`: Int): Int {
        for(i in 0 until k) {
            if (temp[i] < `val`) {
                for(j in k - 1 downTo i + 1) {
                    temp[j] = temp[j - 1]
                }
                temp[i] = `val`
                break
            }
        }
        if (size < k) size ++
        return temp[size - 1]
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */