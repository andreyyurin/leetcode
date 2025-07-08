class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length == 1) return s
        var result = ""

        for (i in 0 until s.length) {

            for (j in s.length - 1 downTo i + 1) {
                if (s[i] == s[j]) {
                    var l = i
                    var r = j
                    var temp = ""
                    while(s[l] == s[r] && l <= r) {
                        if (l == r) {
                            var res = temp + s[l] + temp.reversed()
                            if (result.length < res.length) {
                                if(res.length == s.length) return res
                                result = res
                            }
                            break
                        }
                        temp+=s[l]
                        l++
                        r--
                    }
                    if (l > r) {
                        var res = temp + temp.reversed()
                        if (result.length < res.length) {
                            if(res.length == s.length) return res
                            result = res
                        }
                    }
                }
            }
        }

        return if(result.isEmpty()) "${s[0]}" else result
    }
}