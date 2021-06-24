import java.util.LinkedList;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        // BFS solution
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0) return res;
        res.offer("");
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int idx = digits.charAt(i) - '2';
            int res_size = res.size();
            for (int j = 0; j < res_size; j++) {
                String s = res.poll();
                for (char c: map[idx].toCharArray()) {
                    res.offer(s + c);
                }
            }
        }
        return res;
    }
}
// @lc code=end

