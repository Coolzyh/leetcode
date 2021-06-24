/*
 * @lc app=leetcode id=18 lang=cpp
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        // Hashset solution
        sort(nums.begin(), nums.end());
        return kSum(nums, target, 0, 4);
    }

    vector<vector<int>> kSum(vector<int>& nums, int target, int start, int k) {
        vector<vector<int>> res;
        // Note that nums.size() return unsigned int
        // So we can't use start > nums.size()-k, which can be negative
        if (start+k > nums.size() || nums[start]*k > target || nums.back()*k < target) return res;
        if (k == 2) return twoSum(nums, target, start);
        for (int i = start; i < nums.size(); i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            for (auto& set: kSum(nums, target-nums[i], i+1, k-1)) {
                res.push_back({nums[i]});
                res.back().insert(res.back().end(), set.begin(), set.end());
            }
        }
        return res;
    }

    vector<vector<int>> twoSum(vector<int>& nums, int target, int start) {
        vector<vector<int>> res;
        unordered_set<int> set;
        for (auto i = start; i < nums.size(); i++) {
            if (set.find(target - nums[i]) != set.end()) {
                if (res.empty() || res.back()[1] != nums[i]) {
                    res.push_back({target-nums[i], nums[i]});
                }
            }
            set.emplace(nums[i]);
        }
        return res;
    }
};
// @lc code=end

