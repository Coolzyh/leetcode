/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            while (nums[left] == nums[right]) {
                right++;
                if (right==nums.length) return left+1;
            }
            nums[++left] = nums[right];
            right++;
        }
        return left+1;
    }
}
// @lc code=end

