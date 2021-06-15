import java.util.Arrays;

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int[] sum = new int[digits.length+1];
        int carry = 0;
        for (int i = digits.length-1; i>=0; i--) {
            if (i == digits.length-1) {
                sum[i+1] = (digits[i] + 1)%10;
                carry = (digits[i] + 1)/10;
            } else {
                sum[i+1] = (digits[i] + carry)%10;
                carry = (digits[i] + carry)/10;
            }
        }
        sum[0] = carry;
        if (carry == 1) return sum;
        else {
            return Arrays.copyOfRange(sum, 1, sum.length);
        }
    }
}
// @lc code=end

