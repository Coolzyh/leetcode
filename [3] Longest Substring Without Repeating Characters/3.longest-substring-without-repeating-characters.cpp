/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> mymap;
        int len = 0;
        int j = 0;
        for (int i=0; i<s.length(); i++) {
            auto it = mymap.find(s[i]);
            if (it != mymap.end()) {
                j = (mymap.at(s[i]) >= j)?mymap.at(s[i])+1:j;
            } 
            mymap[s[i]] = i;
            len = max(i-j+1, len);
        }
        return len;
    }
};
// @lc code=end

