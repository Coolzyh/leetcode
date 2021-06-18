/*
 * @lc app=leetcode id=104 lang=cpp
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        // BFS
        if (root == nullptr) return 0;
        queue<TreeNode*> q;
        int res = 0;
        q.push(root);
        while (!q.empty()) {
            int n = q.size();
            while (n > 0) {
                n--;
                root = q.front();
                q.pop();
                if (root->left != nullptr) {
                    q.push(root->left);
                }
                if (root->right != nullptr) {
                    q.push(root->right);
                }
            }
            res++;
        }
        return res;
    }
};
// @lc code=end

