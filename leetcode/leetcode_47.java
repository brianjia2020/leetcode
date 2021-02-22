package leetcode;

import java.util.*;

public class leetcode_47 {
    //Permutation II
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i-1]==nums[i]&&!visited[i-1]) continue;
            if(visited[i]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            dfs(res,temp,nums,visited);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
