package company_questions.amazon.VO;

import utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
    //recursive
    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        if (root1.val==root2.val){
            return isSymmetric(root1.left,root2.right)&&isSymmetric(root1.right,root2.left);
        } else {
            return false;
        }
    }

    //iterative
    public boolean isSymmetric2(TreeNode root){
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null&&right==null) continue;
            if(left==null||right==null) return false;
            if(left.val!=right.val) return false;
            queue.offer(left.left); queue.offer(right.right);
            queue.offer(left.right); queue.offer(right.left);
        }

        return true;
    }
}
