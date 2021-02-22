package company_questions.amazon.VO;

import utility.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k){
        //edge cases:
        if(head==null||head.next==null) return head;
        if(k==0) return head;
        //solution:
        //1. get the length of the LinkedList,k=k%length
        //2. loop get to the point of length-k, pre.next=null, tail.next = head
        //3. return cur
        ListNode pre = null;
        ListNode cur = head;
        ListNode tail = head;
        int length = getLength(head);
        while(tail.next!=null){
            tail = tail.next;
        }

        k = k%length;
        if(k==0) return head;
        for(int i=length-k;i>0;i--){
            pre = cur;
            cur = cur.next;
        }

        pre.next=null;
        tail.next = head;
        return cur;
    }

    public int getLength(ListNode head){
        int res = 0;
        while(head!=null){
            res += 1;
            head = head.next;
        }
        return res;
    }
}
