package leetcode_easy;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isSymmetric2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode q1 = queue.poll();
            TreeNode q2 = queue.poll();
            if(q1==null&&q2==null) continue;
            if(q1==null||q2==null) return false;
            if(q1.val!=q2.val) return false;
            queue.add(q1.left);
            queue.add(q2.right);
            queue.add(q1.right);
            queue.add(q2.left);
        }
        return true;
    }

    public boolean isMirror(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null||node2==null) return false;
        return (node1.val==node2.val) && isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
