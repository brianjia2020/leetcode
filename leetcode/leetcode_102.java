package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelNums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                levelNums.add(temp.val);
            }
            result.add(levelNums);
        }
        return result;
    }
}
