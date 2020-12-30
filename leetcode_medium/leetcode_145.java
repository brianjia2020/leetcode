package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

public class leetcode_145 {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }


}
