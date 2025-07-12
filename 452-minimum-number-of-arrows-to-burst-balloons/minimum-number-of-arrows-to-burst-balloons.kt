class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }

        val tempList = mutableListOf<IntArray>()
        //println(points.map {"${it[0]} ${it[1]}"})

        tempList.add(points[0])

        var counter = 1
        for (i in 1 until points.size) {
            if (points[i][0] > tempList[counter - 1][1]) {
                tempList.add(intArrayOf(points[i][0], points[i][1]))
                counter++
            }
        }

        return counter
    }
}