import java.util.HashMap;
import java.util.Hashtable;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> ht = new HashMap<>();
        Node current = head;
        while (current != null) {
            // Create nodes copy
            if (!ht.containsKey(current)) {
                ht.put(current, new Node(current.val));
            }
            // Create random and next relation
            if (current.random != null && !ht.containsKey(current.random)) {
                ht.put(current.random, new Node(current.random.val));
            }
            if (current.next != null && !ht.containsKey(current.next)) {
                ht.put(current.next, new Node(current.next.val));
            }
            ht.get(current).random = ht.get(current.random);
            ht.get(current).next = ht.get(current.next);
            current = current.next;
        }
        return ht.get(head);
    }
}
// @lc code=end

