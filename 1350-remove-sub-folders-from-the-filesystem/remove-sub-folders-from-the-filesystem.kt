class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val list = mutableListOf<String>()
        folder.sortBy { it.length }

        folder.forEach { fol ->
            var contains = false
            list.forEach {
                if (fol.startsWith(it)) {
                    contains = true
                }
            }
            if (!contains) {
                list.add("$fol/")
            }
        }
        return list.map { it.removeRange(it.length-1, it.length)}
    }
}