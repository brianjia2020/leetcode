package leetcode_medium;

public class leetcode_708 {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head==null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node max = head;
        while(max.next != head && max.val <= max.next.val){
            max = max.next;
        }
        Node min = max, cur = min;
        if (insertVal >= max.val || insertVal<= min.val){
            Node node = new Node(insertVal,min);
            max.next = node;
        } else {
            while(cur.next.val < insertVal){
                cur = cur.next;
            }
            Node node = new Node(insertVal,cur.next);
            cur.next = node;
        }
        return head;
    }


}

