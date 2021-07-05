import java.util.ArrayList;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int nums_len = nums.length;
        for (int i = 0; i < nums_len; i++) {
            int res_len = res.size();
            for (int j = 0; j < res_len; j++) {
                List<Integer> current = new ArrayList<>(res.get(j));
                current.add(nums[i]);
                res.add(new ArrayList<>(current));
            }
        }
        return res;
    }
}
// @lc code=end

