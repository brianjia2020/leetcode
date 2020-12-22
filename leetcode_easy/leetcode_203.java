package leetcode_easy;

public class leetcode_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = null;
        ListNode tempHead = null;
        while(head!=null){
            if (head.val!=val){
                ListNode newNode = new ListNode(head.val);
                if (temp==null){
                    tempHead = newNode;
                    temp = newNode;
                } else {
                    temp.next = newNode;
                    temp = temp.next;
                }
            }
            head = head.next;
        }
        return tempHead;
    }
}
