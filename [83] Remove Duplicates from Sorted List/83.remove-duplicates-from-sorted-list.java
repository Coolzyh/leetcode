/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode();
        ListNode current = head;
        dummy.next = head;
        int current_val = head.val;
        while (head != null) {
            if (head.val == current_val) {
                head = head.next;
            }
            else {
                current_val = head.val;
                current.next = head;
                current = current.next;
                head = head.next;
            }
        }
        current.next = null;
        return dummy.next;
    }
}
// @lc code=end

