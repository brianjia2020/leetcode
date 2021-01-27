package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode_230 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest(root,1));
    }

    public int kthSmallest(TreeNode root, int k) {
        int currElem=0;
        return kthSmallestElement(root,currElem,k);
    }

    public int kthSmallestElement(TreeNode root,int currElem,int k){
        if (root != null) {
            int resL = kthSmallestElement(root.left, currElem, k);
            if (currElem == k) {
                return resL;
            }
            currElem++;
            if (currElem == k) {
                return root.val;
            }

            int resR = kthSmallestElement(root.right, currElem, k);
            if (currElem==k){
                return resR;
            }
        }
        return -1;
    }


    public int kthSmallest2(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        return arr.get(k);
    }
    public void inOrder(TreeNode node, List<Integer> arr){
        if (node == null) return;
        inOrder(node.left,arr);
        arr.add(node.val);
        inOrder(node.right,arr);
    }
}

class TreeNode {
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