import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);
        boolean turnRight = false;
        while (!st.isEmpty()) {
            turnRight = !turnRight;
            int st_size = st.size();
            Deque<Integer> cur = new LinkedList<>();
            while (st_size > 0) {
                root = st.removeFirst();
                if (turnRight) {
                    cur.addLast(root.val);     
                } else {
                    cur.addFirst(root.val);
                }
                if (root.left != null) st.addLast(root.left);
                if (root.right != null) st.addLast(root.right);
                st_size--;
            }
            res.add(new ArrayList<>(cur));
        }
        return res;
    }
}
// @lc code=end

