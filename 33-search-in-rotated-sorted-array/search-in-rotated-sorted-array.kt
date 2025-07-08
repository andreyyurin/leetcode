class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        val list = mutableListOf<Pair<Int, Int>>()

        while(l <= r) {
            if (l == r) {
                list.add(l to nums[l])
            } else {
                list.add(r to nums[r])
                list.add(l to nums[l])
            }
            l++
            r--
        }

        list.sortBy { it.second }

        l = 0
        r = nums.size - 1

        while(l <= r) {
            val mid = l+(r - l) / 2

            if (list[mid].second == target) {
                return list[mid].first
            } else if (list[mid].second > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        return -1
    }
}