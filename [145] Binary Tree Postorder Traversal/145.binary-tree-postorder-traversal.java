/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !st.empty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                st.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
// @lc code=end

