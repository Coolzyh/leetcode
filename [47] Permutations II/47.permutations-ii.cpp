/*
 * @lc app=leetcode id=47 lang=cpp
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        // this method swap nums position
        vector<vector<int>> res;
        DFS(nums, res, 0);
        return res;
    }

    // permute num[start..end]
    // invariant: num[0..start-1] have been fixed/permuted
    void DFS(vector<int>& nums, vector<vector<int>>& res, int start) {
        if (start == nums.size()) {
            res.emplace_back(nums);
            return;
        } else {
            for (int i = start; i < nums.size(); i++) {
                int j = i-1;
                //judge whether num[i] and num[start], ..., nums[i-1] are equal
                while(j >= start && nums[j] != nums[i]) {
                    j--;
                }
                if (j == start-1) {
                    swap(nums[start], nums[i]);
                    DFS(nums, res, start+1);
                    // reset
                    swap(nums[start], nums[i]);
                }
            }
        }
    }
};
// @lc code=end

