class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var point = 1
        var counterZero = 0
        var counterMinus = 0
        var l = 0
        var r = nums.size - 1
        while(l <= r) {
            if(l == r) {
                if (nums[l] == 0) {
                    counterZero++
                } else {
                    point *= nums[l]
                }
                if (nums[l] < 0) {
                    counterMinus++
                }
            } else {
                if (nums[r] == 0) {
                    counterZero++
                } else {
                    point *= nums[r]
                }
                if (nums[r] < 0) {
                    counterMinus++
                }

                if (nums[l] == 0) {
                    counterZero++
                } else {
                    point *= nums[l]
                }
                if (nums[l] < 0) {
                    counterMinus++
                }
            }

            l++
            r--
        }
        

        val list = IntArray(nums.size)

        l = 0
        r = nums.size - 1
        while(l <= r) {
            if (l == r) {
                if(nums[l] == 0 && counterZero > 1) {
                    list[l] = (0)
                } else if (nums[l] == 0 && counterZero == 1) {
                    list[l] = (point)
                } else if(counterZero > 0) {
                    list[l] = (0)
                } else if (nums[l] < 0) {
                    if (counterMinus - 1 % 2 == 0) {
                        list[l] = (point / nums[l])
                    } else {
                        list[l] = (point / nums[l])
                    }
                } else {
                    list[l] = point / nums[l]
                }
            } else {
                if(nums[r] == 0 && counterZero > 1) {
                    list[r] = (0)
                } else if (nums[r] == 0 && counterZero == 1) {
                    list[r] = (point)
                } else if(counterZero > 0) {
                    list[r] = (0)
                } else if (nums[r] < 0) {
                    if (counterMinus - 1 % 2 == 0) {
                        list[r] = (point / nums[r])
                    } else {
                        list[r] = (point / nums[r])
                    }
                } else {
                    list[r] = point / nums[r]
                }

                if(nums[l] == 0 && counterZero > 1) {
                    list[l] = (0)
                } else if (nums[l] == 0 && counterZero == 1) {
                    list[l] = (point)
                } else if(counterZero > 0) {
                    list[l] = (0)
                } else if (nums[l] < 0) {
                    if (counterMinus - 1 % 2 == 0) {
                        list[l] = (point / nums[l])
                    } else {
                        list[l] = (point / nums[l])
                    }
                } else {
                    list[l] = point / nums[l]
                }
            }


            l++
            r--
        }
        
        return list
    }
}