class Solution {
    val ans = mutableListOf<List<Int>>()
    lateinit var temp: IntArray

    fun permute(nums: IntArray): List<List<Int>> {
        temp = nums
        go(0, mutableListOf<Int>())
        return ans.map { it.map { nums[it] } } 
    }

    fun go(index: Int, list: MutableList<Int>) {
        if (list.size == temp.size) {
            ans.add(list)
            return
        }
        for(i in 0 until temp.size) {
            if (!list.contains(i)) {
                go(index + 1, (list + i) as MutableList<Int>)
            }
        }
    }
}