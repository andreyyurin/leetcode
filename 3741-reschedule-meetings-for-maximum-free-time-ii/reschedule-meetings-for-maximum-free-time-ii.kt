class Solution {
    // 4ый день задач про митинги, 4ый день украденного дейли
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
      val len = startTime.size
        val freeIntervals = IntArray(len+1)
        freeIntervals[0] = startTime[0]
        for (i in 1 until len) {
            freeIntervals[i] = startTime[i] - endTime[i-1]
        }
        freeIntervals[len] = eventTime - endTime[len-1]
        val max_pref = IntArray(len+1)
        val max_post = IntArray(len+1)
        for (i in 1 .. len) {
            max_pref[i] = Math.max(max_pref[i-1],freeIntervals[i-1])
            max_post[len-i] = Math.max(max_post[len-i+1],freeIntervals[len-i+1])
        }
        var rez = 0
        for (i in 0 until len) {
            var tek_max = freeIntervals[i]+freeIntervals[i+1]
            val meetings = endTime[i] - startTime[i]
            if (max_pref[i]>=meetings || max_post[i+1]>=meetings)
                tek_max += meetings
            rez = Math.max(rez,tek_max)
        }
        return rez   
    }
}