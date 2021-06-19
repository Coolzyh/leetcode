/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.length() == 0) return s;
        int start = 0;
        int res_len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandfromCenter(i, i, s);
            int len2 = expandfromCenter(i, i+1, s);
            int len = max(len1, len2);
            if (res_len < len) {
                res_len = len;
                start = (i + len/2)-len+1;  //start = end-len+1
            }
        }
        return s.substr(start, res_len);
    }

    int expandfromCenter(int left, int right, string s) {
        while (left >= 0 && right < s.length()) {
            if (s[left] == s[right]) {
                left--;
                right++;
            } else break;
        }
        return right-left-1;
    }
};
// @lc code=end

