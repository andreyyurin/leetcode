class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }

        var start = points[0][1]

        var counter = 1
        for (i in 1 until points.size) {
            if (points[i][0] > start) {
                start = points[i][1]
                counter++
            }
        }

        return counter
    }
}