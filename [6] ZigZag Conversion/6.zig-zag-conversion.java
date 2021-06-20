/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (s.length() <= numRows) return s;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            boolean go_up = true;
            StringBuilder line = new StringBuilder();
            while (j < s.length()) {
                line.append(s.charAt(j));
                if (i == 0 || i == numRows-1) {
                    j += 2*(numRows - 1);
                } else {
                    j += (go_up)? 2*(numRows - 1 - i): 2*i;
                    go_up = !go_up;
                }
            }
            res.append(line);
        }
        return res.toString();
    }
}
// @lc code=end

