class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()
        var result= mutableListOf<String>()
        var prev = 0
        for (i in 0 until nums.size) {
            if (i > 0) {
                if (nums[i] - nums[i - 1] == 1){ 
                    continue
                } else {
                    
                    if (prev == i - 1) {
                        result.add("${nums[i-1]}")
                    } else if (nums[i] == nums[i - 1]) {
                        result.add("${nums[i]}")
                    } else {
                        result.add("${nums[prev]}->${nums[i-1]}")
                    }
                    prev = i
                }
            }
        }
        if (prev <= nums.size - 1) {
            if (prev == nums.size - 1 || nums[prev] == nums[nums.size-1]) {
                result.add("${nums[nums.size - 1]}")
            } else {
                result.add("${nums[prev]}->${nums[nums.size-1]}")
            }
        }

        return result
    }
}