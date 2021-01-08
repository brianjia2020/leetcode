package leetcode_medium;

import com.sun.source.tree.Tree;
import org.junit.Test;

public class leetcode_236 {
    private TreeNode ans=null;

    @Test
    public void test1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(ans);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        recurseTree(root,p,q);
        return ans;
    }

    public boolean recurseTree(TreeNode cur, TreeNode p, TreeNode q){
        if(cur==null) return false;
        int left = recurseTree(cur.left,p,q)?1:0;
        int right = recurseTree(cur.right,p,q)?1:0;
        int mid = (cur==p||cur==q)?1:0;
        if(mid+left+right>=2) ans=cur;
        return (mid+left+right>0);
    }
}
