import java.util.ArrayList;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    public void backTracking(int[] candidates, List<List<Integer>> res, List<Integer> temp_list, int target, int start) {
        if (target == 0) {
            // Note that we need to new an ArrayList, since temp_list is changing during the rest running time and will become []
            // Explain: https://stackoverflow.com/questions/7080546/add-an-object-to-an-arraylist-and-modify-it-later
            res.add(new ArrayList<>(temp_list));
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp_list.add(candidates[i]);
                backTracking(candidates, res, temp_list, target-candidates[i], i);
                temp_list.remove(temp_list.size()-1);
            }
        }
    }
}
// @lc code=end

