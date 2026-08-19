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
    public ListNode removeElements(ListNode head, int val) {
        // Remove matching nodes from the beginning
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;   // Remove current node
            } else {
                prev = curr;             // Move prev only if node is kept
            }
            curr = curr.next;
        }

        return head;
    }
}