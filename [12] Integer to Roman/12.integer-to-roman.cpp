/*
 * @lc app=leetcode id=12 lang=cpp
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
public:
    string intToRoman(int num) {
        // Solution after reading discussion
        // Making the first 3 arrays char* rather than string reduces runtime
    static char* ones[10] =     { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static char* tens[10] =     { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    static char* hundreds[10] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    static string thousands[4] = { "", "M", "MM", "MMM" };
    
    int th = num/1000;
    num -= th*1000;
    int h = num/100;
    num -= h*100;
    int t = num/10;
    int o = num - t*10;
    
    return thousands[th]+hundreds[h]+tens[t]+ones[o];
    }
};
// @lc code=end

