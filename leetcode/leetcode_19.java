package leetcode;

public class leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
//        System.out.println(length);
        if (n<0 || n >length) return null;

        ListNode pre = null;
        ListNode cur = head;
        for (int i =0;i<length-n;i++){
            pre = cur;
            cur = cur.next;
        }
        if (pre==null){
            head = head.next;
        } else if (cur.next==null){
            pre.next = null;
        }
        else {
            pre.next = cur.next;
        }
        return head;
    }

    public int getLength(ListNode head){
        int length = 0;
        while(head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
}
