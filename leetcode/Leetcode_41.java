package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class Leetcode_41 {
    @Test
    public void test(){
        int [] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if ( nums == null || nums.length == 0) return 1;
        int n = nums.length;
        boolean [] exists = new boolean[n+1];
        int i = 0;
        while (i < n){
            if(nums[i]>0 && nums[i]<n+1) exists[nums[i]-1] = true;
            i++;
        }
        System.out.println(Arrays.toString(exists));
        for(int j=0; j<exists.length;j++) if(!exists[j]) return j+1;
        return n+1;
    }

}
