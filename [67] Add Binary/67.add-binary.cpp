/*
 * @lc app=leetcode id=67 lang=cpp
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
public:
    string addBinary(string a, string b) {
        string s;
        int carry = 0;
        for (int i = a.length()-1, j = b.length()-1; i>=0 || j>=0 || carry>0; i--, j--) {
            int sum = ((i>=0)?a[i]-'0':0) + ((j>=0)?b[j]-'0':0) + carry;
            carry = sum/2;
            s = s+char(sum%2 + '0');
        }
        reverse(s.begin(), s.end());
        return s;
    }
};
// @lc code=end

