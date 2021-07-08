/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        // Calculate the length of the linked list
        int list_len = 0;
        ListNode dummy = new ListNode(0, head);
        while (head != null) {
            list_len++;
            head = head.next;
        }
        k = k%list_len;
        head = dummy.next;
        if (k == 0) return dummy.next;;
        ListNode current = head;
        while ((list_len - k) > 1) {
            current = current.next;
            k++;
        }
        dummy.next = current.next;
        current.next = null;
        current = dummy.next;
        while (current.next != null) current = current.next;
        current.next = head;
        return dummy.next;
    }
}
// @lc code=end

