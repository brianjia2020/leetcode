package leetcode_easy;

public class leetcode_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
