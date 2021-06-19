/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        boolean[][] T = new boolean[s.length()][];  // T(i, j): s[i]...s[j] is a palindromic or not
        for (int i = 0; i < s.length(); i++) {
            T[i] = new boolean[s.length()-i];
            T[i][0] = true;
        }
        for (int i = 0; i < s.length()-1; i++) {
            T[i][1] = (s.charAt(i) == s.charAt(i+1));
        }
        for (int k = 2; k < s.length(); k++) {
            for (int i = 0; i < s.length()-k; i++) {
                T[i][k] = (T[i+1][k-2] && (s.charAt(i+k) == s.charAt(i)));
            }
        }
        int ind_i = 0;
        int ind_j = 0;
        int max_len = 0;
        for (int k = 0; k < s.length(); k++) {
            for (int i = 0; i < s.length()-k; i++) {
                if (T[i][k] && max_len < k+1) {
                    ind_i = i;
                    ind_j = i+k;
                    max_len = k+1;
                }
            }
        }
        return s.substring(ind_i, ind_j+1);
    }
}
// @lc code=end

