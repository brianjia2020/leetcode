package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class leetcode_414 {
    @Test
    public void test(){
        int i = thirdMax(new int[]{2,2,3,1});
        System.out.println(i);
    }

    public int thirdMax(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        if (set.size() > 2) {
            set.remove(Collections.max(set));
            set.remove(Collections.max(set));
        }
        return Collections.max(set);
    }
}
