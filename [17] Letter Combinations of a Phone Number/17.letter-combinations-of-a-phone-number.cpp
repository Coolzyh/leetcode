/*
 * @lc app=leetcode id=17 lang=cpp
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        // DFS recursive method
        vector<string> res;
        if (digits.empty()) return res;
        const vector<string> map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        DFS_recurse(digits, map, res, "", 0);
        return res;
    }

    void DFS_recurse(const string& digits, const vector<string>& map, vector<string>& res, string temp, int start) {
        // temp is the temporary string we get
        if (temp.length() == digits.length()) {
            res.push_back(temp);
        } else {
            for (int i = 0; i < map[digits[start]-'2'].length(); i++) {
                DFS_recurse(digits, map, res, temp+map[digits[start]-'2'][i], start+1);
            }
        }
    }
};
// @lc code=end

