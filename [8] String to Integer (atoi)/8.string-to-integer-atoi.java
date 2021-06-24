/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int i = 0, ans = 0, sign = 1, len = s.length();
		if (s.charAt(i) == '-' || s.charAt(i) == '+')
			sign = s.charAt(i++) == '+' ? 1 : -1;
		for (; i < len; i++) {
			int tmp = s.charAt(i) - '0';
			if (tmp < 0 || tmp > 9)
				break;
			if (ans > Integer.MAX_VALUE / 10
					|| (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			else
				ans = ans * 10 + tmp;
		}
		return sign * ans;
    }
}
// @lc code=end

