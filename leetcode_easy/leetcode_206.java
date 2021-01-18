package leetcode_easy;

public class leetcode_206 {
    //1. iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //2. recursive
    private ListNode temp2;
    public ListNode reverseList2(ListNode head){
        if(head==null||head.next==null) {
            temp2 = head;
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next = reverseList2(head.next);
        return temp2;
    }



    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }
}



/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
