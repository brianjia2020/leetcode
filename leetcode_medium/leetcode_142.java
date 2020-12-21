package leetcode_medium;


import java.util.HashSet;

public class leetcode_142 {

    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode interaction = hasCycle(head);
        if (interaction==null) return null;
        while(head != interaction){
            head = head.next;
            interaction = interaction.next;
        }
        return interaction;
    }

    public ListNode hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return fast;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            if (set.contains(head)){
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
