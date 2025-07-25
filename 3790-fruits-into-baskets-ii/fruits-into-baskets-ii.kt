class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        
        for (i in 0 until fruits.size) {
            for(j in 0 until baskets.size) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = -1
                    fruits[i] = -1
                    break
                }
            }
        }

        return fruits.filter { it != -1 }.count() 
    }
}