package leetcode_easy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_112 {
    //1. recursion
    public boolean hasPathSum(TreeNode root, int sum){
        if(root==null) return false;
        sum -= root.val;
        if(root.left==null&&root.right==null) return (sum==0);
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
    //2. iterative
    public boolean hasPathSum2(TreeNode root, int sum){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(sum-root.val);
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            int curr_sum = queue2.poll();
            if(node.left==null&&node.right==null&&curr_sum==0) return true;
            if(node.left!=null) {
                queue1.add(node.left);
                queue2.add(curr_sum-node.left.val);
            }
            if(node.right!=null) {
                queue1.add(node.right);
                queue2.add(curr_sum-node.right.val);
            }
        }
        return false;
    }
}
