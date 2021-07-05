/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Apply Divide and Conquer
        // time complexity O(N * log k)
        // N is total number of nodes in the result linked list
        int k = lists.length;
        if (k == 0) return null;
        if (k == 1) return lists[0];
        int interval = 1;
        while (interval < lists.length) {
            System.out.println(lists.length);
            for (int i = 0; i + interval < lists.length; i = i+interval*2) {
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);            
            }
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Time complexity O(n1 + n2)
        // n1, n2 is the number of nodes for the two linked lists
        ListNode dummyhead = new ListNode(0);
        ListNode current = dummyhead;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            current.next = (val1<val2)? l1 : l2;
            current = current.next;
            l1 = (val1<val2)? l1.next: l1;
            l2 = (val1<val2)? l2:l2.next;
        }
        current.next = (l1 != null)? l1: l2;
        return dummyhead.next;
    }
}
// @lc code=end

