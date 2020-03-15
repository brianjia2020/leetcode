package leetcode;

import com.atguigu.statement.crud.List;

public class leetcode_1290 {
    public static void main(String[] args) {
        ListNode v1 = new ListNode();
        v1.val = 1;
        v1.next = new ListNode();
        v1.next.val = 0;
        v1.next.next = new ListNode();
        v1.next.next.val =1;
        System.out.println(getDecimalValue(v1));
    }

    public static int getDecimalValue(ListNode head) {
        int result = 0;
        int position = 0;
        ListNode new_head = head;
        while (new_head != null){
            position++;
            new_head = new_head.next;
        }

        while(head != null){
            position --;
            result += head.val * Math.pow(2,position);
            head = head.next;
        }
        return result;
    }
}

class ListNode{
    int val;
    ListNode next;
    void vListNode(int x){
        val = x;
    }
}
