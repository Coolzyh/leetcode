/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        // Apply KMP algorithm
        // https://www.cnblogs.com/grandyang/p/6992403.html
        // https://wiki.jikexueyuan.com/project/kmp-algorithm/define.html
        if (needle.length() == 0) return 0;
        // Calculate the next table
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < next.length-1) {
            if (k == -1 || needle.charAt(k) == needle.charAt(j)) {
                next[j+1] = k+1;
                k = next[j+1];
                j++;
            } else {
                k = next[k];
            }
        }
        // KMP
        int p = 0;
        int q = 0;
        while (p<haystack.length() && q<needle.length()) {
            if (q == -1 || haystack.charAt(p) == needle.charAt(q)) {
                p++;
                q++;
            } else {
                q = next[q];    // right move needle q-next[q]
            }
        }
        if (q == needle.length()) return p-q;
        else return -1;   
    }
}
// @lc code=end

