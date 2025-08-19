class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var res = 0L
        var current = 0L
        for(num in nums) {
            if(num == 0){
                current++
            }else if(current > 0){
                res += current * (current + 1) / 2
                current = 0
            }
        }
        if(current > 0)
            res += current * (current + 1) / 2

        return res
        
    }
}