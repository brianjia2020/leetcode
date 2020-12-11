package leetcode_easy;

public class leetcode_21 {
    //1. iterative
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode res = resHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }

        if (l1 != null){
            res.next = l1;
        }

        if (l2 != null){
            res.next = l2;
        }

        return resHead.next;
    }

    //2. recursion
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 :l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
