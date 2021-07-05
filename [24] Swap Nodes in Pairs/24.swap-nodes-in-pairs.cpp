/*
 * @lc app=leetcode id=24 lang=cpp
 *
 * [24] Swap Nodes in Pairs
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
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr) return head;
        ListNode dummy;
        dummy.next = head;
        ListNode *current = &dummy;
        while (current->next && current->next->next) {
            ListNode *first = current->next;
            ListNode *second = current->next->next;
            first->next = second->next;
            current->next = second;
            second->next = first;
            current = first;
        }
        return dummy.next;
    }
};
// @lc code=end

