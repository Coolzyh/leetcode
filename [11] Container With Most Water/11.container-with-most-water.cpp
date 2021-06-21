/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        // O(n) solution
        int i = 0, j = height.size()-1;
        int volume = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                volume = max(volume, height[i]*(j-i));
                i++;
            }
            else {
                volume = max(volume, height[j]*(j-i));
                j--;
            }
        }
        return volume;
    }
};
// @lc code=end

