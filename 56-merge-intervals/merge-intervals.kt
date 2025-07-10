class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val temp = mutableListOf<Pair<Int, Int>>()

        intervals.sortBy { it[0] }
        var maxEnd = Int.MIN_VALUE
        var currentStart = intervals[0][0]

        intervals.forEach {
            if (maxEnd == Int.MIN_VALUE) {
                maxEnd = it[1]
                currentStart = it[0]
            } else if (it[1] >= maxEnd && it[0] <= maxEnd) {
                maxEnd = it[1]
            } else if (it[1] <= maxEnd) {
                //skip
            } else {
                temp.add(currentStart to maxEnd)
                currentStart = it[0]
                maxEnd = it[1]
            }
        }

        temp.add(currentStart to maxEnd)

        val result = Array(temp.size) {
            IntArray(2)
        }
        temp.forEachIndexed { index, item ->
            result[index] = intArrayOf(item.first, item.second)
        }
        return result

    }
}