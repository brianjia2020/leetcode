package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_1313 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] output = run(nums);
        System.out.println(Arrays.toString(output));

    }

    public static int[] run(int [] nums){
        ArrayList result = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i+=2){
            for(int j = 0; j < nums[i]; j++) {
                result.add(nums[i+1]);
            }
        }

        int [] output = new int [result.size()];
        for (int k = 0; k < result.size(); k++){
            output[k] = (int) result.get(k);
        }
        return output;
    }
}
