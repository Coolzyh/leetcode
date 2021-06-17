/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
public:
    int climbStairs(int n) {
        if (n == 1) return 1;
        int T1 = 1;
        int T2 = 2;
        int result = T2;
        for (int i=2; i<n; i++) {
            result = T2 + T1;
            T1 = T2;
            T2 = result;
        }
        return result;
    }
};
// @lc code=end

