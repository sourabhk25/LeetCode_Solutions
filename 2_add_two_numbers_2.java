import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while(l1 != null || l2!=null || carry!=0){
            int first,second,sum;
            if(l1!=null){
                first = l1.val;
            } else{
                first = 0;
            }
            if(l2!=null){
                second = l2.val;
            } else{
                second = 0;
            }
            sum = first + second + carry;
            carry = sum / 10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }
}