package company_questions.amazon.VO;

import utility.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKSortedLists(ListNode[] lists){
        //edge cases:
        if(lists==null||lists.length==0) return null;
        if(lists.length==1) return lists[0];

        //solution: O(n*logn)
        //1. initiate an empty list as head, PriorityQueue queue to order it
        //2. every time we took the smallest number and let res.next = Node and res = res.next, lists[i] = lists[i].next
        //3. increment until all ListNode in lists are null
        //4. return the head.next

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return Integer.compare(o1.val,o2.val);
            }
        });

        for(ListNode temp: lists){
            if(temp!=null) queue.add(temp);
        }

        ListNode res = new ListNode(0);
        ListNode head = res;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            if (temp.next!=null) queue.add(temp.next);
            res.next = temp;
            res = res.next;
        }
        return head.next;
    }
}
