/*
 * @lc app=leetcode id=100 lang=cpp
 *
 * [100] Same Tree
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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // DFS (with stack)
        if (p == nullptr && q == nullptr) return true;
        if (p == nullptr || q == nullptr) return false;
        stack<TreeNode*> st;
        st.push(q);
        st.push(p);
        while (!st.empty()) {
            p = st.top();
            st.pop();
            q = st.top();
            st.pop();
            if (p == nullptr && q == nullptr) continue;
            if (p == nullptr || q == nullptr || p->val != q->val) return false;
            st.push(q->right);
            st.push(p->right);
            st.push(q->left);
            st.push(p->left);
        }
        return true;
    }
};
// @lc code=end

