/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s.equals(" ")) return 0;
        int i = s.length()-1;
        int len = 0;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0) {
            if (s.charAt(i) == ' ') return len;
            len++;
            i--;
        }
        return len;
    }
}
// @lc code=end

