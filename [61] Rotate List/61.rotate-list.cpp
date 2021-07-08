/*
 * @lc app=leetcode id=61 lang=cpp
 *
 * [61] Rotate List
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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == nullptr || head->next == nullptr||k==0) return head;
        ListNode* node = head;
        int size = 1;  
        while(node->next != nullptr) {
            size++;
            node = node->next;
        }
        //handle the case of k>size
        k = k%size;
        if (k == 0) return head;
        //loop the list
        node->next=head;
        //find the node to break the loop at
        while(--size >= k) {
            node=node->next;
        }
        ListNode* first = node->next;
        node->next = nullptr;
        return first;
    }
};
// @lc code=end

