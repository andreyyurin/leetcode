class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        var k = 0
        var res = Int.MAX_VALUE

        for(i in 0 until nums.size) {
            sum += nums[i]
            k++
            if (sum >= target) {
                if (sum - nums[i - k + 1] >= target) {
                    var temp = 0
                    var f = 0
                    for(j in i downTo i - k + 1) {
                        temp += nums[j]
                        f++
                        if (temp>=target) {
                            k = min(k, f)
                            res = min(k, min(res, f))
                            break
                        }
                    }
                    sum = temp
                } else {
                    res = min(k, res)
                }
            }
        }
        
        return if(sum < target) 0 else res
    }
}