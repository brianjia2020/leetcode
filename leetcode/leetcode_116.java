package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_116 {
    public Node connect1(Node root){
        if(root==null) return null;
        Node leftmost = root;
        while(leftmost.left!=null){
            Node head = leftmost;
            while(head!=null){
                head.left.next = head.right;
                if(head.next!=null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node prev= null;
            int n =queue.size();
            for(int i =0;i<n;i++){
                Node node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(prev!=null) prev.next=node;
                prev=node;
            }
            prev.next=null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
