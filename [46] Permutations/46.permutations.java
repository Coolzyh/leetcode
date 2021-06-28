import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(nums, res, new ArrayList<Integer>());
        return res;
    }

    public void DFS(int[] nums, List<List<Integer>> res, List<Integer> temp_list) {
        if (temp_list.size() == nums.length) {
            res.add(new ArrayList<>(temp_list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp_list.contains(nums[i])) continue;
                temp_list.add(nums[i]);
                DFS(nums, res, temp_list);
                temp_list.remove(temp_list.size()-1);
            }
        }
    }
}
// @lc code=end

