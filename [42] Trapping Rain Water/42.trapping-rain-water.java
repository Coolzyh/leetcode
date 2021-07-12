import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // My first solution
        if (height.length < 3) return 0;
        int volume = 0;
        int n = height.length;
        int i = 0, j = 0;
        while (i < n-1) {
            Stack<Integer> st = new Stack<>();
            for (j = i+1; j < n; j++) {
                if (height[j] < height[i]) {
                    st.push(height[j]);
                } else break;
            }
            if (j == n) {
                st.pop();
                while (!st.isEmpty()) {
                    if (st.peek() < height[n-1]) {
                        volume += height[n-1]-st.pop();
                        j--;
                    } else break;
                }
                n = j-1;
            } else {
                while (!st.isEmpty()) {
                    volume += height[i]-st.pop();
                }
                i = j;
            }
        }
        return volume;
    }
}
// @lc code=end

