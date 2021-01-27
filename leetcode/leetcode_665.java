package leetcode;

import org.junit.Test;

public class leetcode_665 {
    @Test
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) return true;
        int count = 0;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                count++;
                if (count > 1) return false;
                if(i-2 < 0 || nums[i-2] <= nums[i]){
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return true;
    }
}
