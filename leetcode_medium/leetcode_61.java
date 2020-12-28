package leetcode_medium;

public class leetcode_61 {

    //1.
    public ListNode rotateRight(ListNode head, int k){
        if (head==null || head.next==null) return head;


        ListNode pre = null;
        ListNode tail = head;
        ListNode cur = head;
        int length = 1;
        while(tail.next!=null){
            length++;
            tail = tail.next;
        }

        k = k%length;
        if (k==0) return head;
        for(int i = length-k;i>0;i--){
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        tail.next = head;
        return cur;
    }




    //2. time exceeding
    public ListNode rotateRight2(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        ListNode node = head;
        for(int i =0;i<k;i++){
            node = rotate(node);
        }
        return node;

    }

    public ListNode rotate(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur.next!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next = null;
        cur.next = head;
        return cur;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
