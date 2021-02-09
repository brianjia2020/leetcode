package leetcode;

import org.junit.Test;

public class leetcode_236 {
    private TreeNode ans=null;

    @Test
    public void test1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode treeNode = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(treeNode);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;
        if (root == p || root == q) return root;

        //Divide
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //Conquer
        if(left!=null&&right!=null){
            return root;
        } else if(left==null) {
            return right;
        } else if(right==null) {
            return left;
        } else {
            return null;
        }
    }


}
