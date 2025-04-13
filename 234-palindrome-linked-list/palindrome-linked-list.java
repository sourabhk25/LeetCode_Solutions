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
    public boolean isPalindrome(ListNode head) {
        //basic - put all numbers in array and then use 2 pointers
        List<Integer> values = new ArrayList<>();
        //convert linkedlist to ArrayList
        ListNode temp = head;
        while(temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int front = 0;
        int back = values.size() - 1;
        while(front < back) {
            if(values.get(front) != values.get(back)) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}