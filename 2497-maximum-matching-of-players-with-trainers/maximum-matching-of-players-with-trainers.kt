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
        // val maxTrainer = trainers.last()
        // var counter = 0

        // var lPlayer = 0
        // var rPlayer = players.size - 1

        // println(players.map { it })
        // println(trainers.map { it })
        // var result = 0
        // var lTrainer = 0
        // var rTrainer = trainers.size - 1
        // var map = mutableMapOf<Int, Boolean>()
        // while(lPlayer <= rPlayer) {
        //     if(lTrainer > rTrainer) break

        //     if (players[lPlayer] > trainers[lTrainer]) {
        //         lTrainer++
        //     } else {
        //         lPlayer++
        //         lTrainer++
        //         if (map[lTrainer] != true) {
        //             result++
        //             map[lTrainer] = true
        //         }
        //     }

        //     if (players[rPlayer] > trainers[rTrainer]) {
        //         rPlayer--
        //     } else {
        //         rPlayer--
        //         rTrainer--

        //         if (map[rTrainer] != true && lTrainer < rTrainer) {
        //             result++
        //             map[rTrainer] = true
        //         }
        //     }

        // }

        return result
    }
}