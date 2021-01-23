package company_questions.amazon;

import org.w3c.dom.Node;
import utility.ListNode;

import java.util.HashMap;

public class Q17_CopyListWithRandomPointer {
    public static ListNode copyRandomList(ListNode head){
        HashMap<ListNode,ListNode> map = new HashMap<>();
        ListNode cur = head;
        while(cur!=null){
            map.put(cur,new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode random;
        public ListNode(int val){this.val=val;}
    }
}
