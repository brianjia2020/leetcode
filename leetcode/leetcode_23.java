package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_23 {
    //1. while with priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        Queue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode list: lists){
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next = node;
            if (node.next != null){
                queue.add(node.next);
            }
            tail = tail.next;
        }
        return dummy.next;
    }

    //2.merge sort
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int l,int r){
        if (l>r) return null;
        if (l==r) return lists[l];
        if (l+1==r) return mergerTwoLists(lists[l],lists[r]);
        int m = l+ (r-1)/2;
        ListNode l1 = merge(lists,l,m);
        ListNode l2 = merge(lists,m+1,r);
        return mergerTwoLists(l1,l2);
    }

    public ListNode mergerTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1==null?l2:l1;
        return dummy.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
