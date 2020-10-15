package leetcode_easy;

import org.junit.Test;

public class leetcode_104 {

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

    @Test
    public void test(){

    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            int height = Math.max(left_height,right_height) + 1;
            return height;
        }
    }

}
