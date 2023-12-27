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
        Queue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);    //creating min heap to store heads of lists
        for(ListNode l: lists) {    //add all non-null heads of all lists to heap
            if(l != null) {
                q.offer(l);
            }            
        }

        ListNode head = new ListNode(-1);   //creating dummy ListNode
        ListNode temp = head;
        while(!q.isEmpty()) {
            temp.next = q.poll();   //pull out min node from min heap and attach to output list
            temp = temp.next;   //move temp pointer
            if(temp.next != null) { //if next element present in list then add it to heap
                q.offer(temp.next);
            }
        }

        return head.next;   //return dummy's next
    }
}