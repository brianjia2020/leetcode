package leetcode;

public class leetcode_27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int num:nums){
            if(num!=val){
                nums[i] =num;
                i++;
            }
        }
        return i;
    }
}
