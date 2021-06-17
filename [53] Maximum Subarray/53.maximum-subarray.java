/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int T = nums[0];  //T(i): max sub-array sum for x_0, ..., x_i including x_i
        int max = T;
        for (int i=1; i<nums.length; i++) {
            T = (T>=0)? (T+nums[i]): nums[i];
            max = Math.max(max, T);
        }
        return max;
    }
}
// @lc code=end

