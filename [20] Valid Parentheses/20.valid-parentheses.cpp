/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
public:
    bool isValid(string s) {
        stack<int> st;
        for (int i = 0; i<s.length(); i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                st.push(s[i]);
            } else if (!st.empty()) {
                if (s[i] == ')' && st.top() == '(') {
                    st.pop();
                } else if (s[i] == '}' && st.top() == '{') {
                    st.pop();
                } else if (s[i] == ']' && st.top() == '[') {
                    st.pop();
                } else return false;
            } else return false;
        }
        return st.empty();
    }
};
// @lc code=end

