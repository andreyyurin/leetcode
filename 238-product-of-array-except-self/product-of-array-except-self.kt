class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var point = 1
        var counterZero = 0
        var counterMinus = 0
        nums.forEach {
            if (it == 0) {
                counterZero++
            } else {
                point *= it
            }
            if (it < 0) {
                counterMinus++
            }
        }

        val list = IntArray(nums.size)

        nums.forEachIndexed { index, it ->
            if(it == 0 && counterZero > 1) {
                list[index] = (0)
            } else if (it == 0 && counterZero == 1) {
                list[index] = (point)
            } else if(counterZero > 0) {
                list[index] = (0)
            } else if (it < 0) {
                if (counterMinus - 1 % 2 == 0) {
                    list[index] = (point / it)
                } else {
                    list[index] = (point / it)
                }
            } else {
                list[index] = point / it
            }
        }
        
        return list
    }
}