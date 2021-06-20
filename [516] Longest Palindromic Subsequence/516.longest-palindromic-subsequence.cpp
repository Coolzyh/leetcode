/*
 * @lc app=leetcode id=516 lang=cpp
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int size = s.length();
        if (size == 0) return 0;
        if (size == 1) return 1;
        // DP
        vector<vector<int>> T(2, vector<int>(size, 0));
        // T(i, j): the length of the longest Palindromic Subsequence of s_i,...,s_j
        // T(i, j) = T(i+1, j-1) + 2 if (s_i == s_j)
        // T(i, j) = max(T(i+1, j), T(i, j-1)) if (s_i != s_j)
        // T(i, i) = 1
        // Since T(i, j) only based on this line (i) and the next line (i+1)
        // We can use 2xsize array to save memory
        // Initialization
        int cur = 0;  // current line
        for (int i = size - 1; i >= 0; i--) {
            T[cur][i] = 1;
            for (int j = i+1; j < size; j++) {
                if (s[i] != s[j]) {
                    T[cur][j] = max(T[1-cur][j], T[cur][j-1]);
                } else {
                    T[cur][j] = T[1-cur][j-1] + 2;
                }
            }
            cur = 1-cur;
        }
        return T[1-cur][size-1];
    }
};
// @lc code=end

