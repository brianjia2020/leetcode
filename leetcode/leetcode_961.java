package leetcode;

import java.util.HashMap;

public class leetcode_961 {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int num: A){
            int freq = cache.getOrDefault(num,0);
            if (freq >= 1){
                return num;
            }
            cache.put(num, freq+1);
        }
        return 0;
    }

}
