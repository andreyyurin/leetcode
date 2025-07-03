class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true
        var l = 0L
        var r = num - 1L
        val n = num.toLong()

        while(l < r) {
            val mid = l + (r-l) / 2L
            if (mid * mid > n) {
                r = mid - 1
            } else if (mid * mid == n){
                l = mid
                break
            } else {
                l = mid + 1
            }

        }

        return (l * l).toInt() == num
    }
}