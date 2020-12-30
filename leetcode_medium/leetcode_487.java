package leetcode_medium;

public class leetcode_487 {
    public int findMaxConsecutiveOnes(int[] nums){
        int count1 = 0,count2=0, ret = 0;
        for(int num: nums){
            if(num==0){
                count2 = count1+1;
                count1 = 0;
            } else {
                count1++;
                count2++;
            }
            ret = Math.max(ret,count2);
        }
        return ret;
    }
}
