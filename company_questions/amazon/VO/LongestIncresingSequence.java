package company_questions.amazon.VO;

import java.util.Arrays;

public class LongestIncresingSequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for(int num: nums){
            int index = Arrays.binarySearch(dp,0,len,num);
            if(index<0) index = -index-1;
            dp[index] = num;
            if(index==len) len++;
        }
        return len;
    }
}
