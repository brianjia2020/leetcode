package leetcode;

public class leetcode_162 {
    public int findPeakElement(int[] nums){
        return helper(nums,0,nums.length-1);
    }

    public int helper(int[] nums, int left, int right){
        if(left >= right) return left;

        int mid = (left+right)/2;
        if(nums[mid]<nums[mid+1]){
            return helper(nums,mid+1,right);
        } else {
            return helper(nums,left,mid);
        }
    }
}
