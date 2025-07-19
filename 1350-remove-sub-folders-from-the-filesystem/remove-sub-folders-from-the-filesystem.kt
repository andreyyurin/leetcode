class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val list = mutableListOf<String>()
        folder.sortBy { it.length }

        folder.forEach { fol ->
            var contains = false
            for (i in list) {
                if (fol.startsWith(i)) {
                    contains = true
                    break
                }
            }
            if (!contains) {
                list.add("$fol/")
            }
        }
        return list.map { it.removeRange(it.length-1, it.length)}
    }
}