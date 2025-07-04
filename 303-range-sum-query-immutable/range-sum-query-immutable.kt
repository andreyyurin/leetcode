class NumArray(val nums: IntArray) {

    fun sumRange(left: Int, right: Int): Int {
        var temp = 0
        for(i in left..right) {
            temp+=nums[i]
        }
        return temp
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */