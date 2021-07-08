/*
 * @lc app=leetcode id=138 lang=cpp
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (head == nullptr) return nullptr;
        // no hashmap solution
        Node* current = head;
        Node* next = nullptr;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (current) {
            next = current->next;
            Node* copy = new Node(current->val);
            current->next = copy;
            copy->next = next;
            current = next;
        }
        // Second round: assign random pointers for the copy nodes.
        current = head;
        while (current) {
            if (current->random) {
                current->next->random = current->random->next;
            }
            current = current->next->next;
        }
        // Third round: restore the original list, and extract the copy list.
        Node* copyhead = head->next;
        current = head;
        while (current) {
            next = current->next->next;
            Node* copy = current->next;
            current->next = next;
            if (next) copy->next = next->next;
            current = next;
        }

        return copyhead;
    }
};
// @lc code=end

