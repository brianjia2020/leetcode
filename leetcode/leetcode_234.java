package leetcode;

public class leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;
        while(slow!=null){
            if (slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node){
        ListNode temp = null;
        while(node!=null){
            ListNode next = node.next;
            node.next = temp;
            temp = node;
            node = next;
        }
        return temp;
    }

    public int getLength(ListNode temp){
        int n = 0;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        return n;
    }
}
