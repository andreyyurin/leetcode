class Solution {
    fun numberOfSteps(num: Int): Int {
     var c = 0
     var t = num
     while(t > 0) {
        if (t % 2 == 0) {
            t /= 2
        } else {
            t -= 1
        }
        c++
     }  
     return c 
    }
}