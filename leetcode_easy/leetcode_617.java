package leetcode_easy;


public class leetcode_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == null ? t2:t1;
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left,t2.left);
        newNode.right = mergeTrees(t1.right,t2.right);
        return newNode;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
