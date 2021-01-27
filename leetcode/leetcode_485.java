package leetcode;

public class leetcode_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int temp = 0;
        for (int i =0;i<nums.length;i++){
            if (nums[i]==1){
                temp++;
                if (temp > maxCount) maxCount = temp;
            } else {
                temp = 0;
            }
        }
        return maxCount;
    }
}
