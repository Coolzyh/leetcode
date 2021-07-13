/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String cur: path.split("/")){
            if (cur.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (cur.length()>0 && !cur.equals(".")) stack.push(cur);
        }
        return "/"+String.join("/",stack);
    }
}
// @lc code=end

