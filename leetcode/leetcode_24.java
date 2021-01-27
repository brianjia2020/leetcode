package leetcode;

public class leetcode_24 {
    public ListNode swapPairs(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode temp = head.next;
        helper(head);
        return temp;
    }

    public void helper(ListNode node){
        if (node==null||node.next==null) return;
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = node;
        helper(node.next.next);
    }
}
