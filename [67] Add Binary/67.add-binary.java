/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for (int i = a.length()-1, j = b.length()-1; i>=0 || j>=0; i--, j--) {
            int sum = ((i>=0)? a.charAt(i):'0') + ((j>=0)? b.charAt(j):'0') - '0' - '0' + carry;
            s.append(sum%2);
            carry = sum/2;
        }
        if (carry>0) s.append(carry);
        return s.reverse().toString();
    }
}
// @lc code=end

