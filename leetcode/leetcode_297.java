package leetcode;

import org.junit.Test;
import utility.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_297 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode node = deserialize(serialize);
        System.out.println(node);
    }
    public String serialize(TreeNode root){
        String res = "";
        if (root==null) {
            res+= "#,";
        } else {
            res += root.val + ",";
            res += serialize(root.left);
            res += serialize(root.right);
        }
        return res;
    }


    public TreeNode deserialize(String data){
        List<String> s = new ArrayList<>(Arrays.asList(data.split(",")));
        return helper(s);
    }

    public TreeNode helper(List<String> data){
        if(data.get(0).equals("#")){
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
        System.out.println(data);
        data.remove(0);
        root.left = helper(data);
        root.right = helper(data);
        return root;
    }
}
