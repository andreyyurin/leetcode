class Solution {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        var intervalLen = 0
        for (i in 0 until k) {
            intervalLen += endTime[i] - startTime[i]
        }

        var start = 0
        var ans = 0
        for (i in k..startTime.size) {
            val rightBound = if (i == startTime.size) eventTime else startTime[i]
            val total = rightBound - start
            val freeTime = total - intervalLen
            ans = max(ans, freeTime)
            if (i != startTime.size) {
                start = endTime[i - k]
                intervalLen -= endTime[i - k] - startTime[i - k]
                intervalLen += endTime[i] - startTime[i]
            }
        }

        return ans
    }
}