/*
 * @lc app=leetcode id=8 lang=cpp
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string s) {
        if (s.length() == 0) return 0;
        int i = 0;
        while (s[i] == ' ') i++;
        if (s.length() == i) return 0;
        int ans = 0, sign = 1;
        if (s[i] == '+' || s[i] == '-') {
            sign = (s[i] == '+')? 1: -1;
            i++;
        }
        while (s[i] >= '0' && s[i] <= '9') {
            int temp = s[i] - '0';
            if (ans > INT_MAX/10 || (ans == INT_MAX/10 && temp > INT_MAX%10)) {
                return (sign == 1)? INT_MAX: INT_MIN;
            } else {
                ans = ans*10+temp;
                i++;
            }
        }
        return sign*ans;
    }
};
// @lc code=end

