class Solution {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sort()
        trainers.sort()

        var i = 0
        var j = 0
        var result = 0
        while(i < players.size) {
            if (j >= trainers.size) break

            if(players[i] <= trainers[j]) {
                result++
                i++
                j++
            } else {
                j++
            }
        }
        return result
    }
}