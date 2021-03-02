package leetcode;

public class leetcode_747 {

    public int dominantIndex(int[] nums){
        //edge cases:
        if(nums==null||nums.length==0) return -1;
        //solution:
        //1. find the max element O(n)
        //2. loop over to compare each element to the max element, O(n)
        int max = Integer.MIN_VALUE;
        int pos = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                pos = i;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(pos!=i&&max>=nums[i]*2) continue;
            if(pos==i) continue;
            return -1;
        }
        return pos;
    }
}
