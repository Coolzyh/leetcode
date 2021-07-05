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
        int res_len = 1;
        for (int i = 0; i < nums_len; i++) {
            // Whenever the element under consideration has duplicates, 
            // we add one of the duplicate elements to all the existing subsets to create new subsets. 
            // For the rest of the duplicates, we only add them to the subsets created in the previous step. 
            // By convention, whenever a value is encountered for the first time,
            // we add it to all the existing subsets. 
            // Then onwards we add its duplicates only to the subsets created in the previous step.
            int start_idx = (i != 0 && nums[i] == nums[i-1])? res_len: 0;
            res_len = res.size();
            for (int j = start_idx; j < res_len; j++) {
                List<Integer> current = new ArrayList<>(res.get(j));
                current.add(nums[i]);
                res.add(new ArrayList<>(current));
            }
        }
        return res;
    }
}
// @lc code=end

