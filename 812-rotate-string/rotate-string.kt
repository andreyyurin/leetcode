class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        if(s.length != goal.length) return false
        var shift = 0
        while(shift < s.length) {
            val temp = StringBuilder()
            for(i in 0 until s.length) {
                val sh = if (i + shift >= s.length) {
                    i + shift - s.length
                } else {
                    i + shift
                }

                temp.append(s[sh])
            }
            if (temp.toString() == goal) {
                return true
            }
            shift++
        }
        return false
    }
}