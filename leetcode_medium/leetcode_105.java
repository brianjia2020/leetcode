package leetcode_medium;

import java.util.HashMap;
import java.util.Map;

public class leetcode_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //preorder,inorder, location of root in preorder, inorder nodes start, inorder nodes end, map
        return helper(preorder,inorder,0,0,inorder.length-1,map);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preRoot, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preRoot>=preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preRoot]);
        int rootIndex = map.get(preorder[preRoot]);

        root.left = helper(preorder,inorder,preRoot+1,inStart,rootIndex-1,map);
        root.right = helper(preorder,inorder,preRoot+rootIndex-inStart+1,rootIndex+1,inEnd,map);

        return root;
    }
}
