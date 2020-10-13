package leetcode_easy;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_1470 {

    @Test
    public void test(){
        int[] nums = new int[]{2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffle(nums,3)));
    }

    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] newNums = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(i < n){
                newNums[i*2] = nums[i];
            } else{
                newNums[(i-n)*2+1] = nums[i];
            }
        }
        return newNums;
    }
}
