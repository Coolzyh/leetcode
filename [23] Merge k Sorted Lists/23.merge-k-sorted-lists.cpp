/*
 * @lc app=leetcode id=23 lang=cpp
 *
 * [23] Merge k Sorted Lists
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
// #include <vector>
// #include <queue>
// using namespace std;

// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//     ListNode(int x, ListNode *next) : val(x), next(next) {}
// };

class cmp {
public:
    bool operator() (ListNode *a, ListNode *b) {
        return a->val > b->val;
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        // Compare every k nodes (head of every linked list) and get the node with the smallest value.
        // Optimize it by priority queue
        // Time complexity O(N * log k)
        // N is the total number of nodes in the result linked list
        if (lists.size() == 0) return nullptr;
        if (lists.size() == 1) return lists[0];
        priority_queue<ListNode*, vector<ListNode*>, cmp> q;
        for (ListNode* l: lists) {
            if (l) q.push(l);
        }
        ListNode dummy;
        ListNode *current = &dummy;
        while (!q.empty()) {
            current->next = q.top();
            q.pop();
            current = current->next;
            if (current->next) q.push(current->next);
        }
        return dummy.next;
        // without priority queue:
        // ListNode dummy;
        // ListNode *current = &dummy;
        // while (true) {
        //     int min_idx = 0;
        //     int minimum = INT_MAX;
        //     bool isBreak = true;
        //     for (int i = 0; i < lists.size(); i++) {
        //         if (lists[i] != nullptr) {
        //             isBreak = false;
        //             if (lists[i]->val < minimum) {
        //                 minimum = lists[i]->val;
        //                 min_idx = i;
        //             }
        //         }
        //     }
        //     if (isBreak) break;
        //     current->next = lists[min_idx];
        //     current = current->next;
        //     lists[min_idx] = lists[min_idx]->next;
        // }
        // return dummy.next;
    }
};
// @lc code=end

