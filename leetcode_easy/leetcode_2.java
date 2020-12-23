package leetcode_easy;

public class leetcode_2 {
    //1.
    public ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        ListNode dummy= new ListNode(0);
        ListNode tail = dummy;
        int sum = 0;
        while(l1 !=null || l2 != null || sum != 0){
            sum += (l1==null?0:l1.val) + (l2==null?0:l2.val);
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            sum = sum/10;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return dummy.next;
    }

    //2. thie method is time exceeding
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int sum = getNum(l1)+getNum(l2);
        ListNode head = null;
        ListNode temp = head;
        while(sum%10>=0){
            ListNode node = new ListNode(sum%10);
            if (temp==null){
                head = node;
                temp = node;
            } else {
                temp.next=node;
                temp = temp.next;
            }
            sum = sum/10;
        }
        return head;
    }

    public int getNum(ListNode node){
        int num=0;
        int res=0;
        while(node!=null){
            res+= Math.pow(10,num)*node.val;
            node = node.next;
            num++;
        }
        return res;
    }
}
