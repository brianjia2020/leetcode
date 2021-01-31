package leetcode;

public class leetcode_33 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int posRotation = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) {
                posRotation = i;
                break;
            }
        }
        if(posRotation==-1) return binarySearch(nums,target,0,nums.length-1);
        if(target >= nums[posRotation+1] && target <= nums[nums.length-1]) {
            return binarySearch(nums,target,posRotation+1,nums.length-1);
        } else if (target >= nums[0] && target<= nums[posRotation]){
            return binarySearch(nums,target,0,posRotation);
        } else {
            return -1;
        }

    }

    public int binarySearch(int[] nums, int target, int low, int high){
        if(low>high) return -1;
        int mid = low + (high-low)/2;
        if(nums[mid]==target) return mid;
        else if (nums[mid]>target){
            return binarySearch(nums,target,low,mid-1);
        } else {
            return binarySearch(nums,target,mid+1,high);
        }
    }
}
