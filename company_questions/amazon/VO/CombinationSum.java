package company_questions.amazon.VO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,candidates, new ArrayList<>(), target,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] candidates, List<Integer> temp, int target, int index){
        if(target==0){
            res.add(new ArrayList<>(temp));
        }

        for(int i=index;i<candidates.length;i++){
            if (candidates[i]>target) break;
            temp.add(candidates[i]);
            dfs(res,candidates, temp, target-candidates[i],i);
            temp.remove(temp.size()-1);
        }

    }
}
