package leetcode_easy;

public class leetcode_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (sameTree(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean sameTree(TreeNode tree1, TreeNode tree2){
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.val == tree2.val && sameTree(tree1.left,tree2.left) && sameTree(tree1.right,tree2.right);
    }
}

class TreeNode {
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