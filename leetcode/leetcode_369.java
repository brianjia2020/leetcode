package leetcode;

public class leetcode_369 {

    public ListNode plusOne2(ListNode head){
        if(head==null) return new ListNode(1);
        return null;
    }

    //
    public ListNode plusOne(ListNode head){
        if(head==null) return new ListNode(1);
        ListNode cur = head;
        int sum = 0;
        while(cur!=null){
            sum = sum * 10 + cur.val;
            cur = cur.next;
        }
        sum += 1;
        ListNode newHead = new ListNode(-1);
        while(sum>0){
            ListNode digit = new ListNode(sum%10);
            if(newHead.next==null) {
                newHead.next = digit;
            } else {
                ListNode next = newHead.next;
                newHead.next = digit;
                digit.next = next;
            }
            sum /= 10;
        }
        return newHead.next;
    }
}
