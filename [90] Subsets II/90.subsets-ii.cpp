/*
 * @lc app=leetcode id=90 lang=cpp
 *
 * [90] Subsets II
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> output;

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int nums_len = nums.size();
        for (int c = 0; c <= nums_len; c++) {
            vector<int> current;
            backtrack(nums, current, 0, c);
        }
        return output;
    }

    void backtrack(vector<int>& nums, vector<int>& current, int start, int capacity) {
        if (current.size() == capacity) {
            output.emplace_back(current);
            return;
        } else {
            for (int i = start; i < nums.size(); i++) {
                if (i != start && nums[i] == nums[i-1]) continue;
                current.emplace_back(nums[i]);
                backtrack(nums, current, i+1, capacity);
                current.pop_back();
            }
        }
    }
};
// @lc code=end

