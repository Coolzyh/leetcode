import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String cur = tokens[i];
            if (cur.equals("+")) {
                st.addLast(st.removeLast() + st.removeLast());
            } else if (cur.equals("-")) {
                int t1 = st.removeLast();
                int t2 = st.removeLast();
                st.addLast(t2 - t1);
            } else if (cur.equals("*")) {
                st.addLast(st.removeLast() * st.removeLast());
            } else if (cur.equals("/")) {
                int t1 = st.removeLast();
                int t2 = st.removeLast();
                st.addLast(t2 / t1);
            } else st.addLast(Integer.parseInt(cur));
        }
        return st.peekLast();
    }
}
// @lc code=end

