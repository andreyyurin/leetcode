class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        val list = mutableListOf<Int>()

        for (i in 0 until nums.size) {
            var j = 0
            var ind = -1
            while(j < nums.size) {
                var k = if(i + j >= nums.size) {
                    (i + j) - nums.size
                } else {
                    i + j
                }
                if (nums[k] > nums[i]) {
                    ind = k
                    break
                }

                j ++
            }
            if (ind == -1) list.add(-1) else list.add(nums[ind])
        }

        return IntArray(nums.size) {
            list[it]
        }
    }
}