package leetcode;

import java.util.Arrays;

public class leetcode_724 {
    //1.brute force way
    //O(n^2)
    public int pivotIndex(int[] nums){
        for(int i=0;i<nums.length;i++){
            int left=0,right=0;
            int l=i-1,r=i+1;
            while(l>=0) {
                left += nums[l];
                l--;
            }
            while(r<nums.length) {
                right += nums[r];
                r++;
            }
            if(left==right) return i;
        }

        return -1;
    }

    //2. O(n)
    public int pivotIndex2(int[] nums){
        int sum = 0;
        for(int num: nums) sum += num;
        int l=0,r=sum;
        for(int i=0;i<nums.length;i++){
            r -= nums[i];
            if(l==r) return i;
            l += nums[i];
        }
        return -1;
    }
}
