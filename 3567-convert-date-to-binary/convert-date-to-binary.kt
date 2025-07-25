class Solution {
    fun convertDateToBinary(date: String): String {
        val temp = StringBuilder()
        val res = StringBuilder()

        date.forEach {
            if (it == '-') {
                res.append(temp.toString().toInt().toBinary())
                res.append('-')
                temp.clear()
            } else {
                temp.append(it)
            }
        }
        res.append(temp.toString().toInt().toBinary())
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