package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_77 {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> combo = new ArrayList<>();
        combine(combo, new ArrayList<>(),1,n,k);
        return combo;
    }

    public void combine(List<List<Integer>> combo, List<Integer> comb, int start, int n, int k){
        if(k==0) {
            combo.add(comb);
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            combine(combo,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
    }

}
