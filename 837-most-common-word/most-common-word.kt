class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        var result = ""
        val wordMap = mutableMapOf<String, Int>()

        var temp = ""
        val s = paragraph.lowercase()

        for(i in s) {
            if(i.isLetter()) {
                temp+=i
            } else {
                if(temp.length > 0 && !banned.contains(temp)) {
                    wordMap[temp] = (wordMap[temp] ?: 0) + 1
                }
                temp = ""
            }
        }

        if(temp.length > 0 && !banned.contains(temp)) {
            wordMap[temp] = (wordMap[temp] ?: 0) + 1
        }

        var maxResIndex = Int.MIN_VALUE
        var maxRes = ""
        wordMap.forEach {
            if (it.value > maxResIndex) {
                maxResIndex = it.value
                maxRes = it.key
            }
        }
        return maxRes
    }
}