class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        //val commonMap = mutableMapOf<Char, MutableList<MutableList<Int>>>()
        // // f -> [[0], [0], [0]]
        // strs.forEachIndexed { index1, str ->
        //     str.forEachIndexed { index2, c ->
        //         if (commonMap[c] != null) {
        //             if ((commonMap[c]?.size ?: 0) > index1) {
        //                 commonMap[c]!![index1]?.add(index2)
        //             } else {
        //                 commonMap[c]?.add(mutableListOf(index2))
        //             }
        //         } else {
        //             commonMap[c] = mutableListOf<MutableList<Int>>()
        //             commonMap[c]?.add(mutableListOf(index2))
        //         }
        //     }
        // }
        
        // print(commonMap)
        // var resultStr = ""

        // commonMap.forEach { current ->
        //     print(current.key)
        //     print(current.value)
        //     var tempStr = ""
        //     if (current.value.size == strs.size) {
        //         val firstStrIndexes = current.value

        //         firstStrIndexes = 


        //     }
        // }

        var res = ""

        for(i in 0 until strs[0].length) {

            var cancel = false
            strs.forEachIndexed { index, item ->
                if (index > 0 ) {
                    if (i < item.length) {
                        if (item[i] != strs[0][i]) {
                            cancel = true
                            return res
                        }
                    } else {
                        cancel = true
                        return res
                    }
                }
            }

            if(cancel) break

            res += strs[0][i]
        }

        return res
    }

    fun go() {

    }
}