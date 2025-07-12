class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        var counter = 0
        var isAdded = false

        intervals.forEach {
            if (newInterval[0] <= it[1] 
            && (newInterval[0] >= it[0] || newInterval[1] >= it[0])
            && !isAdded) {
                result.add(intArrayOf(min(newInterval[0], it[0]),max(newInterval[1], it[1])))
                counter++
                isAdded = true
            } else if(isAdded) {
                if (it[0] <= result[counter - 1][1]) {
                    result[counter - 1][1] = max(result[counter - 1][1], it[1])
                } else {
                    result.add(it)
                    counter++
                }
            } else {
                result.add(it)
                counter++
            }
        }
        if(!isAdded) {
            if(result.isEmpty()) {
                result.add(newInterval)
            } else if (newInterval[1] < result[0][0]) {
                result.add(0, newInterval)
            } else {
                for(j in result.size - 1 downTo 0) {
                    if (newInterval[0] > result[j][1]) {
                        result.add(j + 1, newInterval)
                        break
                    }
                }
            }
        }

        val res = Array<IntArray>(result.size) { intArrayOf(0, 0) }
        var i = 0
        result.forEach {
            res[i] = it
            i++
        }
        return res
    }
}