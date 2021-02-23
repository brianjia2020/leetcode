package company_questions.amazon.VO;

import utility.TreeNode;

public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root){
        if(root==null) return false;
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long low, long high){
        if(root==null) return true;
        if(root.val>low&&root.val<high){
            return isValid(root.left,low,root.val)&&isValid(root.right,root.val,high);
        } else {
            return false;
        }
    }
}
