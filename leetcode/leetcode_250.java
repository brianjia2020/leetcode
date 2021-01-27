package leetcode;

public class leetcode_250 {
    private int count=0;

    public int countUnivalSubtrees(TreeNode root){
        uniTree(root);
        return count;
    }

    public boolean uniTree(TreeNode node){
        if (node==null) return true;
        if(node.left==null&&node.right==null){
            count++;
            return true;
        }
        boolean isUni = true;
        if(node.left!=null){
            isUni = uniTree(node.left) && node.left.val ==node.val && isUni;
        }
        if(node.right!=null){
            isUni = uniTree(node.right) && node.right.val==node.val && isUni;
        }
        if(!isUni) return false;
        count++;
        return true;
    }
}
