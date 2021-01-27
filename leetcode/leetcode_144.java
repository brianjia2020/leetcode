package leetcode;

import java.util.*;

public class leetcode_144 {
    //1. recursive
    final List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
    //2. breadth first search
    public List<Integer> preorderTraversal2(TreeNode root){
        Queue<TreeNode> stack = new ArrayDeque<>();
        List<Integer> output = new LinkedList<>();
        if(root==null) return output;
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            output.add(node.val);
            if(node.right!=null) stack.add(node.right);
            if(node.left!=null) stack.add(node.left);
        }
        return output;
    }
}
