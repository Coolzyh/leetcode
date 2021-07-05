/*
 * @lc app=leetcode id=89 lang=cpp
 *
 * [89] Gray Code
 */

// @lc code=start
#include <vector>
#include <unordered_set>
using namespace std;
class Solution {
public:
    vector<int> grayCode(int n) {
        // backtracking DFS
        vector<int> res;
        res.push_back(0);
        unordered_set<int> isPresent;
        isPresent.insert(0);
        DFS(res, n, isPresent);
        return res;
    }

private:
    bool DFS(vector<int>& res, int n, unordered_set<int>& isPresent) {
        if (res.size() == (1 << n)) return true;
        int current = res.back();
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (isPresent.find(next) == isPresent.end()) {
                res.push_back(next);
                isPresent.insert(next);
                if(DFS(res, n, isPresent)) return true;
                res.pop_back();
                isPresent.erase(next);
            }
        }
        return false;
    }
};
// @lc code=end

