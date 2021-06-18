import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        // DFS
        Stack<TreeNode> st = new Stack<>();
        st.push(root.right);
        st.push(root.left);
        while (!st.empty()) {
            TreeNode left = st.pop();
            TreeNode right = st.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            st.push(right.left);
            st.push(left.right);
            st.push(right.right);
            st.push(left.left);
        }
        return true;
    }
}
// @lc code=end

