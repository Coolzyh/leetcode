/*
 * @lc app=leetcode id=40 lang=cpp
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<int> current;
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        backTracking(candidates, res, current, target, 0);
        return res;
    }

    void backTracking(vector<int>& candidates, vector<vector<int>>& res, vector<int>& temp_list, int target, int start) {
        if (target == 0) {
            res.emplace_back(temp_list);
            return;
        } else if (target < 0 || start == candidates.size()) return;
        else {
            temp_list.emplace_back(candidates[start]);
            backTracking(candidates, res, temp_list, target-candidates[start], start+1);
            temp_list.pop_back();
            // after that, all combinations start with position start has been processed
            while (start < candidates.size()-1 && candidates[start] == candidates[start+1]) {
                start++;
            }
            backTracking(candidates, res, temp_list, target, start+1);
        }
    }
};
// @lc code=end

