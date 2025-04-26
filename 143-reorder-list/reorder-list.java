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
    public void reorderList(ListNode head) {
        if(head == null)    return;

        ListNode slow = head, fast = head;
        //part 1 - find the middle element first
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow will have middle of list

        //part 2 - reverse the list after middle
        ListNode reverseHead = reverse(slow.next);   //reverse linked list after middle node i.e after slow
        slow.next = null;   //remove connection of middle node
        
        //part 3 - reorder the list
        fast = reverseHead;
        slow = head;

        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    //helper function to reverse linkedlist
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}