/*
 * @lc app=leetcode id=15 lang=cpp
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        if(nums.size()<3) return res;
        sort(nums.begin(), nums.end());
        for(int i = 0; i<nums.size()-2; i++){
            if(nums[i]>0) break;
            if(i==0||nums[i]!=nums[i-1]){
                int lo=i+1,hi=nums.size()-1, sum=-nums[i];
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        vector<int> triplet = {nums[i], nums[lo], nums[hi]};
                        res.push_back(triplet);
                        while(lo<hi&&nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi&&nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if(nums[lo]+nums[hi]<sum) {
                        while(lo<hi&&nums[lo]==nums[lo+1]) lo++;
                        lo++;
                    } else {
                        while(lo<hi&&nums[hi]==nums[hi-1]) hi--;
                        hi--;
                    }
                }                    
            }
        }
        return res;
    }
};
// @lc code=end

