/*
 * @lc app=leetcode id=85 lang=cpp
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        // DP solution
        // The DP solution proceeds row by row, starting from the first row. 
        // Let the maximal rectangle area at row i and column j 
        // be computed by [right(i,j) - left(i,j)]*height(i,j).
        // left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
        // right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
        // height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
        // height(i,j) = 0, if matrix[i][j]=='0'
        if(matrix.empty()) return 0;
        const int m = matrix.size();
        const int n = matrix[0].size();
        int left[n], right[n], height[n];
        fill_n(left,n,0); fill_n(right,n,n); fill_n(height,n,0);
        int maxA = 0;
        for(int i=0; i<m; i++) {
            int cur_left=0, cur_right=n; 
            for(int j=0; j<n; j++) { // compute height (can do this from either side)
                if(matrix[i][j]=='1') height[j]++; 
                else height[j]=0;
            }
            // left[j] record the left most index p which satisfies that for any index q from p to j, height[q] >= height[j];
            for(int j=0; j<n; j++) { // compute left (from left to right)
                if(matrix[i][j]=='1') left[j]=max(left[j],cur_left);
                else {left[j]=0; cur_left=j+1;}
            }
            // compute right (from right to left)
            // right[j] record the right most index p which satifies that for any index q from j to p-1, height[q] >= height[j];
            for(int j=n-1; j>=0; j--) {
                if(matrix[i][j]=='1') right[j]=min(right[j],cur_right);
                else {right[j]=n; cur_right=j;}    
            }
            // compute the area of rectangle (can do this from either side)
            for(int j=0; j<n; j++)
                maxA = max(maxA,(right[j]-left[j])*height[j]);
        }
        return maxA;
    }
};
// @lc code=end

