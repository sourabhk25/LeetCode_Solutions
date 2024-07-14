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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        ListNode temp = head;
        ListNode current = dummy.next;
        ListNode prev = dummy;
        
        while(temp != null) {   //add counts of each node
            count.put(temp.val, count.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        
        // loop through list and check if some value has > 1 nodes then delete that node        
        while(current != null) {
            if(count.get(current.val) > 1) {
                prev.next = current.next;    
            } else {
                prev = current;
            }
            current = current.next;
        }
        
        return dummy.next;
    }
}