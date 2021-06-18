/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // DFS
        if (root == null) return 0;
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> height = new Stack<>();
        st.push(root);
        height.push(1);
        while (!st.empty()) {
            int depth = height.pop();
            res = Math.max(res, depth);
            root = st.pop();
            if (root.right != null) {
                st.push(root.right);
                height.push(depth+1);
            } 
            if (root.left != null) {
                st.push(root.left);
                height.push(depth+1);
            }
        }
        return res;
    }
}
// @lc code=end

