/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char br = s.charAt(i);
            if (br == '(' || br == '{' || br =='[') st.push(br);
            else if (!st.empty()) {
                if (br == ')' && st.peek() == '(') {
                    st.pop();
                } else if (br == '}' && st.peek() == '{') {
                    st.pop();
                } else if (br == ']' && st.peek() == '[') {
                    st.pop();
                } else return false;
            } else return false;
        }
        return st.empty();
    }
}
// @lc code=end

