import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.empty()) {
            while (root != null) {
                res.add(root.val);
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return res;
    }
}
// @lc code=end

