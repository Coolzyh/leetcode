/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode dummy_head = sum;
        int plus = 0;
        while (l1 != null || l2 != null) {
            int temp_sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+plus;
            plus = temp_sum/10;
            sum.next = new ListNode(temp_sum%10);
            sum = sum.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (plus>0) sum.next = new ListNode(plus);
        return dummy_head.next;
    }
}
// @lc code=end

