package leetcode_easy;

import org.junit.Test;

public class leetcode_1480 {
    @Test
    public void test(){

    }

    public int[] runningSum(int[] nums) {
        if (nums.length <= 1) return nums;
        int[] result = new int[nums.length];
        int temp = 0;
        for(int i =0;i<nums.length;i++){
            temp += nums[i];
            result[i] = temp;
        }
        return result;
    }
}
