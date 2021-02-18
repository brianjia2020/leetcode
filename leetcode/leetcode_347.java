package leetcode;

import java.util.*;

public class leetcode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else {
                map.put(num,0);
            }
        }

        Set<Integer> temp = map.keySet();
        List<Integer> temp1 = new ArrayList<>(temp);
        temp1.sort((a, b) -> map.get(b) - map.get(a));
        for(int i = 0; i < k;i++){
            result[i] = temp1.get(i);
        }
        
        return result;
    }

}
