/*
 * @lc app=leetcode id=6 lang=cpp
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
public:
    string convert(string s, int numRows) {
        if (s.length() < numRows) return s;
        if (numRows <= 1) return s;
        vector<string> zig(numRows);
        bool flag = true;
        int row = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            zig[row].push_back(s[i]);
            if (row == 0) flag = true;
            else if (row == numRows-1) flag = false;
            if (flag) row++;
            else row--;
        }
        string res;
        for(auto& temp: zig)
            res += temp;
        return res;
    }
};
// @lc code=end

