class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        var l = left
        var r = right
        val list = mutableListOf<Int>()

        while(l <= r) {
            if (l == r) {
                if(go(l)) list.add(l)
            } else {
                if(go(l)) list.add(l)
                if(go(r)) list.add(r)
            }
            l ++
            r --
        }
        list.sort()
        return list
    }

    fun go(num: Int): Boolean {
        var k = num
        while(k != 0) {
            var t = k % 10
            if (t == 0 || num % t != 0) {
                return false
            }
            k /= 10
        }
        return true
    }
}