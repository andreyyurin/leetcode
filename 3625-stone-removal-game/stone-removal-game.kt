class Solution {
    fun canAliceWin(n: Int): Boolean {
        var s = n
        var turn = 10
        var isAlice = true

        while(s > 0) {
            if (turn <= s) {
                isAlice = !isAlice
                s-=turn
                turn--
            } else {
                return !isAlice
            }
        }     
        return !isAlice
    }
}