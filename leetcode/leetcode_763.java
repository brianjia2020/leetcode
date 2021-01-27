package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_763 {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i =0; i<S.length();i++){
            end = Math.max(end,map.get(S.charAt(i)));
            if (i== end){
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }
}
