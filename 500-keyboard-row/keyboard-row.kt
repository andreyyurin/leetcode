class Solution {
    fun findWords(words: Array<String>): Array<String> {
        val row1 = "qwertyuiop"
        val row2 = "asdfghjkl"
        val row3 = "zxcvbnm"

        val map1 = mutableMapOf<Char, Boolean>()
        val map2 = mutableMapOf<Char, Boolean>()
        val map3 = mutableMapOf<Char, Boolean>()

        row1.forEach {
            map1[it] = true
            map1[it.uppercaseChar()] = true
        }
        row2.forEach {
            map2[it] = true
            map2[it.uppercaseChar()] = true
        }
        row3.forEach {
            map3[it] = true
            map3[it.uppercaseChar()] = true
        }

        val list = mutableListOf<String>()
        words.forEach { word ->
            var k = true
            var prev = -1
            for(j in 0 until word.length) {
                val c1 = map1[word[j]] == true
                val c2 = map2[word[j]] == true
                val c3 = map3[word[j]] == true
                if (c1 && c2) {
                    k = false
                    break
                }

                if (c2 && c3) {
                    k = false
                    break
                }

                if (c1 && c3) {
                    k = false
                    break
                }
                if (prev == -1) {
                    var cur = -1
                    if (c1) cur = 1
                    if (c2) cur = 2
                    if (c3) cur = 3
                    if (cur == -1) {
                        k = false
                        break
                    }
                    prev = cur
                } else {
                    var cur = -1
                    if (c1) cur = 1
                    if (c2) cur = 2
                    if (c3) cur = 3
                    if (cur != prev) {
                        k = false
                        break
                    }
                }
            }
            if (k) list.add(word)
        }
        val array = Array(list.size) {
            list[it]
        }
        return array
    }
}