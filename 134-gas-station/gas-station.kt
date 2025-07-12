class Solution {
    lateinit var costs: IntArray
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        costs = cost
        if(gas.sum() < cost.sum()) return - 1

        gas.forEachIndexed { index, item ->
            var start = index
            var fill = item
            for(i in 0 until gas.size) {
                val nextCost = getNextCost(start)
                val nextIndex = getNextIndex(start)
                
                if (fill < nextCost) {
                    fill = -1
                    break
                } else {
                    fill -= nextCost
                }
                fill += gas[nextIndex]
                start = nextIndex
            }

            if(fill > 0){
                return index
            }
        }

        return -1
        
    }

    private fun getNextCost(i: Int): Int {
        if (i < costs.size) return costs[i]
        else return costs[costs.size - i]
    }

    private fun getNextIndex(i: Int): Int {
        if (i + 1 < costs.size) return i + 1
        else return costs.size - i - 1
    }
}