/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // My first solution (not optimal)
        int n = height.length;
        if (n == 2) return Math.min(height[0], height[1]);
        int volume = 0;
        for (int i = 0; i < n - 1; i++) {
            if (height[i] * (n - 1 - i) <= volume) continue;
            for (int j = n-1; j > i; j--) {
                if (height[i] * (j-i) <= volume) break;
                volume = Math.max(Math.min(height[i], height[j]) * (j-i), volume);
            }
        }
        return volume;
    }
}
// @lc code=end

