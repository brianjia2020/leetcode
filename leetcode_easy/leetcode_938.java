package leetcode_easy;

public class leetcode_938 {
    public static void main(String[] args) {

    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null)
            return 0;
        if(root.val <= R && root.val >= L)
            sum += root.val;
        //       10
        //   7       12
        // 5   9   11   13

        if(L < root.val)
            rangeSumBST(root.left,L,R);
        if(R > root.val)
            rangeSumBST(root.right, L,R);
        return sum;
        }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
