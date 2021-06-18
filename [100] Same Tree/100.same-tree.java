import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // BFS (with queue)
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> que_p = new LinkedList<>();
        Queue<TreeNode> que_q = new LinkedList<>();
        que_p.offer(p);
        que_q.offer(q);
        while (!que_p.isEmpty()) {
            p = que_p.poll();
            q = que_q.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null || p.val != q.val) return false;
            que_p.offer(p.left);
            que_q.offer(q.left);
            que_p.offer(p.right);
            que_q.offer(q.right);
        }
        return true;
    }
}
// @lc code=end

