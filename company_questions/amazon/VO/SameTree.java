package company_questions.amazon.VO;

import utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    //recursively
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        } else {
            return false;
        }
    }

    //iterative
    public boolean isSameTree2(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();
            if(nodeP==null&&nodeQ==null) continue;
            if(nodeP==null||nodeQ==null||nodeP.val!=nodeQ.val) return false;
            queue.offer(nodeP.left);
            queue.offer(nodeQ.left);
            queue.offer(nodeP.right);
            queue.offer(nodeQ.right);
        }

        return true;
    }
}
