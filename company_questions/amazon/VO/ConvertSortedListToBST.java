package company_questions.amazon.VO;

import utility.ListNode;
import utility.TreeNode;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // base case
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        // find the median node in the linked list, after executing this loop
        // fast will pointing to the last node, while slow is the median node.
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) prev.next = null;
        else head = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
