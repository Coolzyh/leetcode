/*
 * @lc app=leetcode id=13 lang=cpp
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> mymap = { { 'I' , 1 },
                                   { 'V' , 5 },
                                   { 'X' , 10 },
                                   { 'L' , 50 },
                                   { 'C' , 100 },
                                   { 'D' , 500 },
                                   { 'M' , 1000 } };
        int num = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (mymap.at(s[i]) < mymap.at(s[i+1])) {
                num -= mymap.at(s[i]);
            } else {
                num += mymap.at(s[i]);
            }
        }
        return num+mymap.at(s.back());
    }
};
// @lc code=end

