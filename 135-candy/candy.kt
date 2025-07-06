class Solution {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size)
        candies[0] = 1

        for(i in 1 until ratings.size) {
            if (ratings[i] < ratings[i - 1]) {
                if(candies[i - 1] > 1) {
                    candies[i] = 1
                } else {
                    candies[i] = 1
                    for(j in i-1 downTo 0) {
                        if (ratings[j] > ratings[j + 1]) {
                            if (candies[j] == candies[j + 1]) candies[j] ++
                        } else {
                            break
                        }
                    }
                    candies[i] = 1
                }
            } else if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            } else {
                candies[i] = 1
            }
        }

        var l = 0
        var r = candies.size - 1
        var sum = 0
        while(l <= r) {
            if (l == r) {
                sum+=candies[l]
            } else {
                sum+=candies[r]
                sum+=candies[l]
            }
            l++
            r--
        }
        return sum
    }
}