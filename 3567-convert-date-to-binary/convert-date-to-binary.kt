class Solution {
    fun convertDateToBinary(date: String): String {
        var temp = ""
        var res = StringBuilder()

        date.forEach {
            if (it == '-') {
                res.append(temp.toInt().toBinary())
                res.append('-')
                temp = ""
            } else {
                temp += it
            }
        }
        res.append(temp.toInt().toBinary())
        return res.toString()
    }

    private fun Int.toBinary(): String {
        var t = this
        var res = ""
        while(t > 0) {
            res = "${(t % 2)}$res"
            t /= 2
        }
        return res
    }
}