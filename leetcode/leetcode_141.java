package leetcode;

import java.util.HashSet;

public class leetcode_141 {
    public boolean hasCycle(leetcode_206.ListNode head) {
        if (head == null) return false;
        leetcode_206.ListNode slow = head;
        leetcode_206.ListNode fast = head.next;

        while(fast != null && fast.next != null){
            if (fast == slow) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    public boolean hasCycle2(leetcode_206.ListNode head){
        if (head==null) return false;
        HashSet<leetcode_206.ListNode> set = new HashSet<>();
        while(head!=null){
            if (set.contains(head)){
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
