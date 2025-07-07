class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var closest = Int.MAX_VALUE
        println(nums.indices)
        for (i in nums.indices) {
            var l = 0
            var r = nums.size - 1
            while(l <= r) {
                if (l != r && l != i && r != i) {
                    val sum3 = nums[i] + nums[l] + nums[r]
                    if(closest == Int.MAX_VALUE || abs(sum3 - target) < abs(closest - target) ) {
                        closest = nums[i] + nums[l] + nums[r]
                        if(closest == target) break
                    }

                    if (sum3 > target) {
                        r--
                    } else {
                        l++
                    }
                } else {
                    l++
                    r--
                }
            }
        }

        return closest
    }
}