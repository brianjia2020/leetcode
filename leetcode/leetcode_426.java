package leetcode;

public class leetcode_426 {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(1);
        root.right = new Node(5);
        leetcode_426 instance = new leetcode_426();
        Node node = instance.treeToDoublyList(root);
        System.out.println(node.val);
    }


    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        Node prev = dummy;
        prev = inorder(root, prev);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private Node inorder(Node node, Node prev) {
        if (node == null) return prev;
        prev = inorder(node.left, prev);
        prev.right = node;
        node.left = prev;
        prev = inorder(node.right, node);
        return prev;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
