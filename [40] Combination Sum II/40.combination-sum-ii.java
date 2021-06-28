import java.util.ArrayList;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    public void backTracking(int[] candidates, List<List<Integer>> res, List<Integer> temp_list, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp_list));
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                // skip repeated candidates
                // i != start means that i > start
                // position start has been processed and we have found all the combinations
                // starting from position start.
                // Therefore, if cand[start+1] == cand[start]
                // there is no need to process position start+1
                // since it will be the subset of combination starting with start position
                if (i != start && candidates[i] == candidates[i-1]) continue;
                temp_list.add(candidates[i]);
                backTracking(candidates, res, temp_list, target-candidates[i], i+1);
                temp_list.remove(temp_list.size()-1);
            }
        }
    }
}
// @lc code=end

