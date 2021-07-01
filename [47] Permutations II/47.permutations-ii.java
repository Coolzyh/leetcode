import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        DFS(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    public void DFS(int[] nums, List<List<Integer>> res, List<Integer> temp_list, boolean[] used) {
        if (temp_list.size() == nums.length) {
            res.add(new ArrayList<>(temp_list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                // this condition is for avoiding repeated [1,1,2] fot the test case
                // In fact, both !used[i-1] and used[i-1] work
                // !used[i-1] makes sure when duplicates are selected, the order is ascending (index from small to large). 
                // However, used[i-1] means the descending order.
                if (i != 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                temp_list.add(nums[i]);
                used[i] = true;
                DFS(nums, res, temp_list, used);
                used[i] = false;
                temp_list.remove(temp_list.size()-1);
            }
        }
    }
}
// @lc code=end

