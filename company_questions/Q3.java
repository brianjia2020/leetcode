package company_questions;

import org.junit.Test;

public class Q3 {

    @Test
    public void test1(){

        System.out.println(reverseRes(new int[]{12,1,2}));
    }

    public int reverseRes(int[]nums){
        int[] reNums = new int[nums.length];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            reNums[i] = reverse(nums[i]);
        }
        for(int i =0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(nums[i]+reNums[j]==nums[j]+reNums[i]) count++;
            }
        }
        return count;
    }

    private int reverse(int num) {
        int res = 0;
        int temp = num;
        int count = 0;
        while(num>0){
            count++;
            num=num/10;
        }
        num = temp;
        while(num>0){
            int i = num%10;
            count--;
            res += i*Math.pow(10,count);
            num=num/10;
        }
        return res;
    }
}
