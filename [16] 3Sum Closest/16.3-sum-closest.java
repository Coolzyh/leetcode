/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // My first solution
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            if (i != 0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int temp_sum = nums[i] + nums[left] + nums[right];
                if (temp_sum == target) return target;
                else if (temp_sum < target) {
                    if (Math.abs(temp_sum - target) < Math.abs(sum - target)) {
                        sum = temp_sum;
                    }
                    while (left < right && nums[left] == nums[left+1]) left++;
                    left++;
                } else {
                    if (Math.abs(temp_sum - target) < Math.abs(sum - target)) {
                        sum = temp_sum;
                    }
                    while (left < right && nums[right] == nums[right-1]) right--;
                    right--;
                }
            }
        }
        return sum;
    }
}
// @lc code=end

