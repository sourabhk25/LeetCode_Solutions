/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;   //to check if cycle is present or not

        //edge case
        if(head == null || head.next == null) { //zero nodes or single node in the list so no cycle possible.
            return null;
        }

        //fast!=null for even length and fast.next!=null for odd
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {  //there is a cycle
                flag = true;
                break;
            }
        }
        if(flag == false) {  //no cycle so return null as answer
            return null;
        }
        
        
        //now we know that slow and fast have met a point and we know that head of cycle is equidistant from that point and head of list
        //so move slow to head and now move both slow and fast by one node only until they meet each other, when they meet that will be start of cycle node
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}