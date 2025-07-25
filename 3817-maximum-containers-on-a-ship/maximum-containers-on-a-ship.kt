class Solution {
    fun maxContainers(n: Int, w: Int, maxWeight: Int): Int {
        val m = n * n * w
        return if (m < maxWeight) {
            n * n
        } else {
            maxWeight / w
        }
    }
}