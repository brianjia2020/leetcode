package leetcode_easy;

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
}
