class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        meetings.sortBy { it[0] }
        val rooms = LongArray(n) { -1L }
        val mapRooms = mutableMapOf<Int, Long>()

        for(i in meetings) {
            var weFindRoom = false
            var minIndex = 0
            var minEnd = Long.MAX_VALUE
            for(j in 0 until rooms.size) {
                if (rooms[j] < minEnd) {
                    minEnd = rooms[j]
                    minIndex = j
                }
                if (i[0] >= rooms[j]) {
                    mapRooms[j] = (mapRooms[j] ?: 0) + 1
                    rooms[j] = i[1].toLong()
                    weFindRoom = true
                    break
                }
            }
            if (!weFindRoom) {
                rooms[minIndex] = minEnd + (i[1] - i[0])
                mapRooms[minIndex] = (mapRooms[minIndex] ?: 0) + 1
            }
        }

        var maxValue = Long.MIN_VALUE
        var keyRoom = 0
        for(i in mapRooms) {
            if(i.value > maxValue) {
                maxValue = i.value
                keyRoom = i.key
            }
        }
        return keyRoom
    }

}