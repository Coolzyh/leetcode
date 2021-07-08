/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode end = pointer;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode prev = null;
            ListNode current = pointer.next;
            ListNode next = null;
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            // pointer.next is the tail of the k nodes (after reverse)
            ListNode tail = pointer.next;
            tail.next = current;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}
// @lc code=end

