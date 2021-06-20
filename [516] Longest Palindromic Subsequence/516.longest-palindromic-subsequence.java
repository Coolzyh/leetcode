/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        // DP
        int[][] T = new int[s.length()][s.length()];
        // T(i, j): the length of the longest Palindromic Subsequence of s_i,...,s_j
        // T(i, j) = T(i+1, j-1) + 2 if (s_i == s_j)
        // T(i, j) = max(T(i+1, j), T(i, j-1)) if (s_i != s_j)
        // T(i, i) = 1
        // Initialization
        for (int i = 0; i < s.length(); i++) {
            T[i][i] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    T[i][j] = Math.max(T[i+1][j], T[i][j-1]);
                } else {
                    T[i][j] = T[i+1][j-1] + 2;
                }
            }
        }
        return T[0][s.length()-1];
    }
}
// @lc code=end

