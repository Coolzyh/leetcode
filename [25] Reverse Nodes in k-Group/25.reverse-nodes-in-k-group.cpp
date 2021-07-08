/*
 * @lc app=leetcode id=25 lang=cpp
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverse(ListNode* first, ListNode* last) {
        ListNode* prev = last;
        ListNode* next = nullptr;
        while (first != last) {
            next = first->next;
            first->next = prev;
            prev = first;
            first = next;
        }
        return prev;
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* node = head;
        for (int i=0; i < k; i++) {
            if (!node ) return head; // nothing to do list too sort
            node = node->next;
        }
        ListNode* new_head = reverse( head, node);
        head->next = reverseKGroup( node, k);
        return new_head;
    }
};
// @lc code=end

