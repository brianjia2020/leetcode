package leetcode;

import java.util.Arrays;

public class leetcode_977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            res[i] = nums[i]*nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}
