class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        var counter = 0

        for(i in 0 until strs[0].length) {
            for(j in 1 until strs.size) {
                if (strs[j][i] < strs[j - 1][i]) {
                    counter++
                    break
                }
            }
        }

        return counter
    }
}