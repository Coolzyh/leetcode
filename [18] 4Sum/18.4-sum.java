import java.util.Arrays;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // My solution: two-pointer
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        if (target < nums[0]*4 || target > nums[nums.length-1]*4) return res;
        for (int i = 0; i < nums.length-3; i++) {
            if (nums[i]*4 > target) break;
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (nums[i] + nums[j]*3 > target) break;
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                int lo = j+1, hi = nums.length-1;
                int sums = target-nums[i]-nums[j];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sums) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sums) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

