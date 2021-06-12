/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mymap = new HashMap<>();
        mymap.put('I', 1);
        mymap.put('V', 5);
        mymap.put('X', 10);
        mymap.put('L', 50);
        mymap.put('C', 100);
        mymap.put('D', 500);
        mymap.put('M', 1000);
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char roman = s.charAt(i);
            if ((i+1 < s.length()) && mymap.get(roman)<mymap.get(s.charAt(i+1))) {
                result += -mymap.get(roman)+mymap.get(s.charAt(i+1));
                i += 2;
            } else {
                result += mymap.get(roman);
                i += 1;
            }
        }
        return result;
    }
}
// @lc code=end

