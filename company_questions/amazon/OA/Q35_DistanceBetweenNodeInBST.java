package company_questions.amazon.OA;

import utility.TreeNode;

public class Q35_DistanceBetweenNodeInBST {
    public static int getDistances(TreeNode root, int node1, int node2){
        if(root==null) return -1;
        TreeNode commonAncestor = findCommonAncestor(root, node1, node2);
        return getDistance(commonAncestor,node1)+getDistance(commonAncestor,node2);
    }

    public static int getDistance(TreeNode commonAncestor,int node){
        if(commonAncestor.val==node) return 0;
        TreeNode temp = commonAncestor.left;
        if(commonAncestor.val<node) temp = commonAncestor.right;
        return 1+getDistance(temp,node);
    }

    public static TreeNode findCommonAncestor(TreeNode root, int node1, int node2){
        while (true){
            if(root.val>node1&&root.val>node2) {
                root = root.left;
            } else if(root.val<node1&&root.val<node2){
                root= root.right;
            } else {
                return root;
            }
        }
    }
}
