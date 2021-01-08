package leetcode_medium;

import java.util.Arrays;

public class leetcode_16 {
    public int threeSumClosest(int[]nums,int target){
        if(nums==null||nums.length<3) return -1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<diff){
                    diff = Math.abs(sum-target);
                    res = sum;
                }
                if(sum==target){
                    return sum;
                } else if (sum<target){
                    left++;
                } else if (sum>target){
                    right--;
                }
            }
        }
        return res;
    }
}
