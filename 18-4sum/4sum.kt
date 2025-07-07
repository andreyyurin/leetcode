class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val map = mutableMapOf<Int, MutableList<Int>>()
        for(i in nums.indices) {
            if (map[nums[i]] == null) map[nums[i]] = mutableListOf(i)
            else map[nums[i]]?.add(i)
        }

        val result = mutableSetOf<List<Int>>()

        for (k in nums.indices) {
        for (i in nums.indices) {
            var l = 0
            var r = nums.size - 1
            while(l <= r) {
                if (l != r && l != i && r != i && l != k && i != k && r != k) {
                    val sum3: Long = nums[i].toLong() + nums[l] + nums[r] + nums[k]
                    if (sum3 == target.toLong()) {
                        val res = listOf(nums[i], nums[r], nums[l], nums[k]).sorted()
                        result.add(res)
                        l++
                        r--
                    } else {
                        if (sum3 > target) {
                            r--
                        } else {
                            l++
                        }
                    }

                } else {
                    if (nums[i] + nums[l] + nums[r] > target) {
                        r--
                    } else {
                        l++
                    }
                }
            }
        }
        }
        return result.toList()
    }

    private fun List<Int>.containsNot(i: Int, l: Int, r: Int): Boolean {
        var s = this.size

        this.forEach {
            if(it == i) {
                s--
            } 
            if(it == l) {
                s--
            } 
            if(it == r) {
                s--
            } 
            if (s == 0) return false
        }
        return s > 0
    }
}