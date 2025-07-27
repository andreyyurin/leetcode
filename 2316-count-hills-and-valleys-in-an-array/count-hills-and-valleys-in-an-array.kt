class Solution {
    fun countHillValley(nums: IntArray): Int {
        val num = mutableListOf<Int>()

        for (i in 0 until nums.size) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                num.add(nums[i])
            } else if (i == 0) {
                num.add(nums[i])
            }
        }
        
        val hill = IntArray(num.size) { 0 }

        for (i in 1 until num.size - 1) {
            if (num[i] > num[i - 1] && num[i] > num[i + 1]) {
                hill[i] = 1 // hill
            } else if (num[i] < num[i - 1] && num[i] < num[i + 1]) {
                hill[i] = 2 // valley
            } else if (num[i] == num[i - 1] && num[i] < num[i + 1] && hill[i - 1] == 2) {
                hill[i] = 2
            } else if (num[i] == num[i - 1] && num[i] > num[i + 1] && hill[i - 1] == 1) {
                hill[i] = 1
            }
        }

        var res = 0

        for(i in 1 until num.size - 1) {
            if (hill[i] != hill[i - 1] && hill[i] != 0) {
                res ++
            }
        }
        return res
    }
}