class Solution {
    fun subarrayBitwiseORs(arr: IntArray): Int = buildList {
        add(setOf(arr[0]))

        for (i in 1 ..< arr.size) {
            val curr = mutableSetOf<Int>(arr[i])

            last().forEach {
                curr.add(it or arr[i])
            }
            add(curr)
        }
    }
        .flatMap { it }
        .toSet()
        .size
}