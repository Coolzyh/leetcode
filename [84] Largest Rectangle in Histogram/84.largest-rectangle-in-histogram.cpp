/*
 * @lc app=leetcode id=84 lang=cpp
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        // stack solution
        // https://www.youtube.com/watch?v=VNbkzsnllsU
        int n = heights.size();
        if (n == 1) return heights[0];
        stack<int> st;    // record the index
        int area = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (!st.empty() && h < heights[st.top()]) {
                int curHeight = heights[st.top()];
                st.pop();
                int rightBoundary = i - 1;
                int leftBoundary = st.empty() ? 0 : st.top() + 1;
                int width = rightBoundary - leftBoundary + 1;
                area = max(area, (curHeight * width));
            }
            st.push(i);
        }
        return area;
    }
};
// @lc code=end

