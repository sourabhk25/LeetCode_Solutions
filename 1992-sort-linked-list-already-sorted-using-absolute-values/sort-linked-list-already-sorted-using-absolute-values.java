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
    public ListNode sortLinkedList(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null) {
            if(curr.val < 0) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}