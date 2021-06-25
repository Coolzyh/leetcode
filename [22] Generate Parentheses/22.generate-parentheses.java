import java.util.ArrayList;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), n, n);
        return res;
    }

    public void backtracking(List<String> res, StringBuilder temp, int left, int right) {
        // left stands for the remaining number of left parentheses
        // right stands for the remaining number of right parentheses
        if (left == 0 && right == 0) {
            res.add(temp.toString());
            return;
        } else {
            if (left > right) return;
            if (left > 0) {
                backtracking(res, temp.append('('), left-1, right);
                temp.deleteCharAt(temp.length()-1);
            }
            if (right > 0) {
                backtracking(res, temp.append(')'), left, right-1);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
// @lc code=end

