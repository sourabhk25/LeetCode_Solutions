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
        BigInteger firstNo, secondNo, sumNo;
        String first = "", second = "", sum ="";
        ListNode current1 = l1, current2 = l2;
        while(current1!=null || current2!=null){
            if(current1!=null){
                first += String.valueOf(current1.val);
                current1 = current1.next;
            }
            if(current2!=null){
                second += String.valueOf(current2.val);
                current2 = current2.next;
            }
        }
        while(current1!=null){
            first += String.valueOf(current1.val);
            current1 = current1.next;
        }
        while(current2!=null){
            second += String.valueOf(current2.val);
            current2 = current2.next;
        }

        StringBuilder firstR = new StringBuilder();
        firstR.append(first);
        firstR.reverse();
        firstNo = new BigInteger(firstR.toString());
        StringBuilder secondR = new StringBuilder();
        secondR.append(second);
        secondR.reverse();
        secondNo = new BigInteger(secondR.toString());
        sumNo = firstNo.add(secondNo);
        sum = String.valueOf(sumNo);
        char[] tempChar = sum.toCharArray();
        ListNode result=null, head=null, toInsert=null;
        for (int i = tempChar.length-1; i >= 0; i--){
            toInsert = new ListNode(Character.getNumericValue(tempChar[i]));
            if(head == null){
                result = toInsert;
                head = result;
            } else{
                result.next = toInsert;
                result = toInsert;
            }
        }
        return head;
    }
}