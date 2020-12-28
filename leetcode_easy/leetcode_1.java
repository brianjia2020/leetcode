package leetcode_easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_1 {
    @Test
    public void test(){
        int[] ints = {2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(ints, 9)));
        System.out.println(Arrays.toString(twoSum2(ints, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i<= nums.length -2; i++){
            for (int j = i+1; j<=nums.length-1;j++){
                if (nums[i]+nums[j]-target == 0) return new int[]{i,j};
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0;i < nums.length;i++){
            final int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
