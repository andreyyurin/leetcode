/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var l = 0
        var r = n - 1
        var mid = 0
        while(l <= r) {
            mid = l+(r - l) / 2
            if (isBadVersion(mid)) {
                r = mid - 1
            } else { 
                l = mid + 1
            }
        }

        return l
	}
}