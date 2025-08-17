class Solution {
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        // If k is 0, the game is already finished, probability = 1
        if (k == 0) return 1.0
        
        // If k + maxPts - 1 <= n, we always win
        if (k + maxPts - 1 <= n) return 1.0
        
        // arrayProb[i] = probability of reaching exactly state i
        val arrayProb = Array<Double>(n + 1) { 0.0 }
        arrayProb[0] = 1.0 // We start with probability 1 at state 0
        
        // windowSum maintains the sum of probabilities from states where we can draw cards
        var windowSum = 1.0
        
        for (i in 1..n) {
            // The probability of reaching i is the sum of probabilities from states
            // from which we can reach i with one card, divided by maxPts
            arrayProb[i] = windowSum / maxPts
            
            // If i < k, we can continue drawing cards from this state
            if (i < k) {
                windowSum += arrayProb[i]
            }
            
            // Remove from the window states that can no longer reach future states
            // If i >= maxPts, state (i - maxPts) can no longer contribute to future states
            if (i >= maxPts) {
                windowSum -= arrayProb[i - maxPts]
            }
        }
        
        // Sum the probabilities of all winning states (k <= i <= n)
        var result = 0.0
        for (i in k..n) {
            result += arrayProb[i]
        }
        
        return result
    }
}