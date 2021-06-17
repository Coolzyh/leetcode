/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int T = nums[0];  //T(i): max sub-array sum for x_0, ..., x_i including x_i
        int max_sum = T;
        for (int i=1; i<nums.size(); i++) {
            T = (T>=0)? (T+nums[i]): nums[i];
            max_sum = max(max_sum, T);
        }
        return max_sum;
    }
};
// @lc code=end

