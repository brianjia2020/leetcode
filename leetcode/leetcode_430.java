package leetcode;

public class leetcode_430 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node){
        if (node==null) return null;
        Node child = node.child;
        Node next = node.next;
        node.child=null;

        if (child!=null&&next!=null) {

            Node childEnd = dfs(child);
            Node nextEnd = dfs(next);

            node.next = child;
            childEnd.next = next;
            child.prev = node;
            next.prev = childEnd;

            return nextEnd;
        } else if (child == null && next != null){
            return dfs(next);
        } else if (child !=null && next == null){
            Node childEnd = dfs(child);
            node.next = child;
            child.prev = node;
            return childEnd;
        } else {
            return node;
        }
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};