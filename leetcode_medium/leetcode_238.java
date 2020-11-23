package leetcode_medium;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_238 {
    @Test
    public void test(){
        int[] result = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {

        int[] L = new int [nums.length];
        int[] R = new int [nums.length];
        Arrays.fill(L,1);
        Arrays.fill(R,1);
        for (int i =1;i<nums.length;i++){
            L[i] = L[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(L));

        for (int i = nums.length-2;i>=0;i--){
                R[i] = R[i+1] * nums[i+1];
        }
        System.out.println(Arrays.toString(R));
        for (int i = 0; i < L.length; i++) {
            L[i] = L[i] * R[i];
        }
        return L;
    }
}
