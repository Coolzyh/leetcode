/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 */

// @lc code=start
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> output;

    vector<vector<int>> subsets(vector<int>& nums) {
        // using backtracking algorithm
        int nums_len = nums.size();
        for (int c = 0; c <= nums_len; c++) {
            vector<int> current;
            backtrack(nums, current, 0, c);
        }
        return output;
    }

    void backtrack(vector<int>& nums, vector<int>& current, int start, int capacity) {
        // capacity is the capacity of current subset to be filled
        if (current.size() == capacity) {
            output.emplace_back(current);
            return;
        } else {
            for (int i = start; i < nums.size(); i++) {
                current.emplace_back(nums[i]);
                backtrack(nums, current, i+1, capacity);
                current.pop_back();
            }
        }
    }
};
// @lc code=end

