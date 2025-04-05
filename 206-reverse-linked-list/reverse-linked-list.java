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

    // public ListNode reverseList(ListNode head) {
    //     ListNode newHead = null;
    //     ListNode curr = head;
    //     while(curr != null) {
    //         ListNode temp = curr.next;
    //         curr.next = newHead;
    //         newHead = curr;
    //         curr = temp;
    //     }

    //     return newHead;
    // }

    public ListNode reverseList(ListNode head) { 
        if(head == null || head.next == null) {
            return head;
        }

        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null; //to remove next ptr link in reversing to avoid cycle
        return result;
    }
}