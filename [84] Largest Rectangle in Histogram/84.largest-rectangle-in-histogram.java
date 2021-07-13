import java.util.Deque;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // My first solution
        if (heights.length == 1) return heights[0];
        int n = heights.length;
        int left = -1, right = 0;
        while (right < n && heights[right] >= heights[0]) right++;
        int area = heights[0]*(right-left-1);
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[i-1]) {
                left = i-1;
                right = i+1;
            }
            while (left >=0 && heights[left] >= heights[i]) left--;
            while (right < n && heights[right] >= heights[i]) right++;
            area = Math.max(area, heights[i]*(right-left-1));
        }
        return area;
    }
}
// @lc code=end

