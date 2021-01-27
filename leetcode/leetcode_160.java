package leetcode;

import java.util.HashSet;

public class leetcode_160 {
    //1. hashset
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    //2. two pointers
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA==null|| headB==null) return null;
        ListNode tempA = headA,tempB = headB;
        while(tempA!=tempB){
            if (tempA==null){
                tempA=headB;
            } else {
                tempA=tempA.next;
            }

            if (tempB==null){
                tempB=headA;
            } else {
                tempB=tempB.next;
            }
        }
        return tempA;
    }
}
