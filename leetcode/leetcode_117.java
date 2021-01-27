package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_117 {
    public Node connect(Node root){
        if(root==null) return null;
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while(Q.size()>0){
            int size = Q.size();
            for(int i =0;i<size;i++){
                Node node = Q.poll();
                if(i<size-1){
                    node.next = Q.peek();
                }
                if(node.left!=null) Q.add(node.left);
                if(node.right!=null) Q.add(node.right);
            }
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
