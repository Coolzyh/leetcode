import java.util.ArrayList;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        // Recursion
        // List<Integer> res = new ArrayList<>();
        // recurse(res, n);
        // return res;
        // In fact it can be rewrote as iteration method
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int res_len = res.size();
            int mask = 1 << (i-1);
            for (int j = res_len-1; j >= 0; j--) {
                res.add(res.get(j) | mask);
            }
        }
        return res;
        // The most elegant solution is to find the relationship between gray(i) and i
        // gray(i) = i XOR (i>>1)
        // int seq_len = 1 << n;
        // for (int i = 0; i < seq_len; i++) {
        //     res.add(i^(i>>1));
        // }
        // return res;
    }

    // private void recurse(List<Integer> res, int n) {
    //     if (n == 0) {
    //         res.add(0);
    //         return;
    //     } else {
    //         recurse(res, n-1);
    //         int res_len = res.size();
    //         int mask = 1 << (n-1);
    //         for (int i = res_len-1; i >= 0; i--) {
    //             res.add(res.get(i) | mask);
    //         }
    //     }
    // }
}
// @lc code=end

