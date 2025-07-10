class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        nums.forEach {
            map[it] = 0
        }
        
        var k = 0
        
        for(i in nums) {
            val value = map[i]!!
            if (value == -1) continue
            else {
                var canGo = true
                var g = 0
                var cur = i
                while(canGo) {
                    if (map[cur] != null && map[cur] != -1) {
                        g++
                        map[cur] = -1
                        cur--
                    }else {
                        break
                    }
                }
                cur = i + 1
                while(canGo) {
                    if (map[cur] != null && map[cur] != -1) {
                        g++
                        map[cur] = -1
                        cur++
                    } else {
                        break
                    }
                }
                k = max(k, g)
            }
        }

        return k
    }
}