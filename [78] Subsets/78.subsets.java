import java.util.ArrayList;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        cascading(nums, res, 0);
        return res;
    }

    public void cascading(int[] nums, List<List<Integer>> res, int current_idx) {
        if (current_idx == nums.length) return;
        int res_len = res.size();
        for (int i = 0; i < res_len; i++) {
            List<Integer> current = new ArrayList<>(res.get(i));
            current.add(nums[current_idx]);
            res.add(current);
        }
        cascading(nums, res, current_idx+1);
    }
}
// @lc code=end

