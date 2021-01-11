package leetcode_medium;

import org.junit.Test;

public class leetcode_98 {
    @Test
    public void test(){
        int a = 2147483647;
        System.out.println(a>=Integer.MAX_VALUE);
    }

    // recursion (divide and conquer)
    public boolean isValidBST(TreeNode root){
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long low, long high){
        //base case -- conquer
        if (node==null) return true;
        if(node.val <= low || node.val >= high) return false;
        //divide into sub problems then combine
        return helper(node.left,low,node.val) && helper(node.right,node.val,high);
    }
}
