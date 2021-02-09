package leetcode;

import java.util.*;

public class leetcode_270 {

    //1.inorder recursive
    public int closestValue(TreeNode root, double target){
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return Collections.min(res,(o1,o2)->{
            return Math.abs(o1-target) < Math.abs(o2-target) ?-1:1;
        });
    }

    public void inorder(TreeNode node, List<Integer> res){
        if(node==null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }

    //2. iterative inorder
    public int closestValue2(TreeNode root, double target){
        LinkedList<TreeNode> stack = new LinkedList<>();

        long prev = Long.MIN_VALUE;

        while(!stack.isEmpty() || root != null){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(prev <= target && target < root.val){
                return Math.abs(prev-target)<Math.abs(target-root.val)? (int) prev:root.val;
            }
            prev = root.val;
            root = root.right;
        }
        return (int) prev;
    }

    //3. iterative
    public int closestValue3(TreeNode root, double target){
        int closest = root.val, val = root.val;
        while(root!=null){
            val = root.val;
            closest = Math.abs(val-target)<Math.abs(closest-target)?val:closest;
            root = root.val > target ? root.left: root.right;
        }
        return closest;
    }

}
