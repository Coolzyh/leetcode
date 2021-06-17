/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] T = new int[2];  //T[i]: the number of ways to the (i+1)-th stair
        T[0] = 1;
        T[1] = 2;
        int result = T[1];
        for (int i=2; i<n; i++) {
            result = T[1] + T[0];
            T[0] = T[1];
            T[1] = result;
        }
        return result;
    }
}
// @lc code=end

