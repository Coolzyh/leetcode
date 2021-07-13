/*
 * @lc app=leetcode id=71 lang=cpp
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
public:
    string simplifyPath(string path) {
        vector<string> st;  // Use vector can reduce time for the last step to get res
        // stack<string> st;
        stringstream paths(path);
        string cur, res;
        while(getline(paths, cur, '/')) {
            if (cur == "" || cur == ".") continue;
            if (cur == "..") {
                if (!st.empty()) st.pop_back();
            } else st.push_back(cur);
        }
        if (st.empty()) return "/";
        for (auto tmp: st) {
            res += "/" + tmp;
        }
        return res;
    }
};
// @lc code=end

