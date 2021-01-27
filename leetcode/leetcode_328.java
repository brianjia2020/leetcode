package leetcode;

public class leetcode_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return null;
        ListNode even=null,evenHead=null,odd=null,oddHead=null,temp=head;
        int count = 0;
        while(head!=null){
            count++;
            if (count%2==0){
                if (even==null){
                    even=head;
                    evenHead=head;
                } else {
                    even.next=head;
                    even=even.next;
                }
            } else {
                if (odd==null){
                    odd=head;
                    oddHead=head;
                } else {
                    odd.next=head;
                    odd=odd.next;
                }
            }

            head = head.next;
        }
        if (even!=null) {
            even.next = null;
        }
        if (odd!=null) {
            odd.next = null;
            odd.next=evenHead;
        }
        return oddHead;
    }
}
