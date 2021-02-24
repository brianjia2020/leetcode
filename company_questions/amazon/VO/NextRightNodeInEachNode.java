package company_questions.amazon.VO;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightNodeInEachNode {

    public Node connect(Node root) {
        //edge cases:
        if(root==null) return null;
        //solution:
        //for each level, we add (left node first then right node and let left node points to the next one from the queue)
        //if it reaches the end of the queue or the end of the level, node.next = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                Node cur = queue.poll();
                if(i<n-1){
                    cur.next = queue.peek();
                } else {
                    cur.next = null;
                }

                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
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
