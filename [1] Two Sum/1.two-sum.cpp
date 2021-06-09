/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mymap;
        for (int i=0; i<nums.size(); i++) {
            auto it = mymap.find(nums[i]);
            if (it != mymap.end()) {
                return vector<int> {i, mymap.at(nums[i])};
            }
            mymap[target-nums[i]] = i;
        }
        return vector<int>{};
    }
};
// @lc code=end

