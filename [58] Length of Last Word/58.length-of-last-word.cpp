/*
 * @lc app=leetcode id=58 lang=cpp
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
public:
    int lengthOfLastWord(string s) {
        if (s.length() == 0 || s.compare(" ") == 0) return 0;
        int i = s.length()-1;
        int len = 0;
        while (i >= 0 && s[i] == ' ') i--;
        while (i >= 0) {
            if (s[i] == ' ') return len;
            len++;
            i--;
        }
        return len;
    }
};
// @lc code=end

