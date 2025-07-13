class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        nums.forEachIndexed { index, item -> 
            if(nums[index]<0) nums[index] = item * -1
        }
        nums.sort()


        return IntArray(size = nums.size) { it->
            nums[it] * nums[it]
        }
        

    }
}