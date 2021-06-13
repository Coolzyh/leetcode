/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode current = dummyhead;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null)? l1.val: 101;
            int val2 = (l2 != null)? l2.val: 101;
            current.next = (val1<val2)? new ListNode(val1) : new ListNode(val2);
            current = current.next;
            l1 = (val1<val2)? l1.next: l1;
            l2 = (val1<val2)? l2:l2.next;
        }
        return dummyhead.next;
    }
}
// @lc code=end

