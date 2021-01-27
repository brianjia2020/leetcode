package leetcode;

public class leetcode_283 {
    public void moveZeros(int[] nums){
        if(nums==null) return;
        int writePointer=0;
        for(int readPointer=1;readPointer<nums.length;readPointer++){
            if(nums[writePointer]!=0){
                writePointer++;
            } else{
                if(nums[readPointer]!=0){
                    nums[writePointer] = nums[readPointer];
                    nums[readPointer]=0;
                    writePointer++;
                }
            }
        }
    }
}
