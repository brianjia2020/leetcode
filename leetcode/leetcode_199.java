package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(rightSideView(root));
    }

    //recursive
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> rightSideView2(TreeNode root){
        if(root==null) return res;
        helper(root,0);
        return res;
    }

    public static void helper(TreeNode node, int level){
        if(level==res.size()) {
            res.add(node.val);
        }
        if(node.right!=null) helper(node.right,level+1);
        if(node.left!=null) helper(node.left,level+1);
    }



    //iterative
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode rightMost = queue.peek();
            res.add(rightMost.val);
            for(int i=queue.size()-1;i>=0;i--){
                TreeNode node = queue.poll();
                if(node!=null) {
                    if (node.right != null) queue.add(node.right);
                    if (node.left != null) queue.add(node.left);
                }
            }
        }
        return res;
    }
}
