package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_39 {

    public static void main(String[] args) {
        leetcode_39 instance = new leetcode_39();
        System.out.println(instance.combinationSum(new int[]{2,3,6,7},7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,candidates, new ArrayList<>(), target,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] candidates, List<Integer> temp, int target, int index){
        if(target==0){
//            System.out.println(temp);
            res.add(new ArrayList<>(temp));
        } else if (target<0) {
        }
        else {
            for(int i=index;i<candidates.length;i++){
                 if (candidates[i]>target) break;
                temp.add(candidates[i]);
                dfs(res,candidates, temp, target-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
