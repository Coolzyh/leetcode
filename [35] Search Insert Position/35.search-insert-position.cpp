/*
 * @lc app=leetcode id=35 lang=cpp
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0, right = nums.size()-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (target < nums[mid]) right = mid-1;
            else if (target > nums[mid]) left = mid+1;
            else return mid;
        }
        return left;
    }
};
// @lc code=end

