/*
 * @lc app=leetcode id=39 lang=cpp
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> current;
        backTracking(candidates, res, current, target, 0);
        return res;
    }

    void backTracking(vector<int>& candidates, vector<vector<int>>& res, vector<int>& temp_list, int target, int start) {
        if (target == 0) {
            // no need to new a temp_list, since std::vector<T>::push_back() creates a copy of the argument and stores it in the vector. 
            res.push_back(temp_list);
            return;
        } else if (target < 0) {
            return;
        } else {
            if (start == candidates.size()) return;
            temp_list.push_back(candidates[start]);
            backTracking(candidates, res, temp_list, target-candidates[start], start);
            temp_list.pop_back();
            backTracking(candidates, res, temp_list, target, start+1);
        }
    }
};
// @lc code=end

