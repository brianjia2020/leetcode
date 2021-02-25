package company_questions.amazon.VO;

import utility.TreeNode;

public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max,left+right);
        return Math.max(left,right) + 1;
    }
}
