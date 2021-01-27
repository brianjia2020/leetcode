package leetcode;

public class leetcode_53 {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i =0; i<nums.length;i++){
            if(currentSum + nums[i] < nums[i]){
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
