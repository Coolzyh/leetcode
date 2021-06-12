import java.util.HashMap;

import javax.xml.stream.events.Characters;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) >= j) {
                j = hm.get(s.charAt(i))+1;
                hm.put(s.charAt(i), i);
            } else {
                hm.put(s.charAt(i), i);
            }
            len = (len<i-j+1)?i-j+1:len;
        }
        return len;
    }
}
// @lc code=end

