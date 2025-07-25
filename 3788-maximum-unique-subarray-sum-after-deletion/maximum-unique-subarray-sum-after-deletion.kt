class Solution {
    val list = mutableListOf<Int>()
    var sum = 0

    fun maxSum(nums: IntArray): Int {
        val map = mutableMapOf<Int, Boolean>() 
        var maxN = Int.MIN_VALUE
        nums.forEach {
            maxN = max(maxN, it)
            if (it > 0) {
                list.add(it)
            }
        }

        if (list.isEmpty()) {
            return maxN
        }
        
        for (i in 0 until list.size){
            if (map[list[i]] == null) {
                map[list[i]] = false
                sum += list[i]
            }
        }

        return sum
    }
    
    fun go() {

    }
}