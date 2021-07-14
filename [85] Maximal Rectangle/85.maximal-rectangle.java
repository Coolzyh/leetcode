/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        if (cols == 0) return 0;
        if (rows == 1 && cols == 1) return (matrix[0][0]-'0');
        int[][] width = new int[cols][rows];   // record the number of successive horizontal "1"s started at [i, j]
        // int[cols][rows] is for easy implement largestRectangleArea function
        for (int i = 0; i < rows; i++) {
            int cur = 0;
            while (cur < cols && matrix[i][cur] == '1') cur++;
            width[0][i] = cur;
            for (int j = 1; j < cols; j++) {
                if (j <= cur) {
                    width[j][i] = cur-j;
                } else {
                    cur++;
                    while (cur < cols && matrix[i][cur] == '1') cur++;
                    width[j][i] = cur-j;
                }
            }
        }
        int area = 0;
        for (int j = 0; j < cols; j++) {
            area = Math.max(area, largestRectangleArea(width[j]));
        }
        return area;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
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

