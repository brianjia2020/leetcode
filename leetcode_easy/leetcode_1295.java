package leetcode_easy;

import java.util.ArrayList;

public class leetcode_1295 {
    public static void main(String[] args) {

    }

    public static int run(int[] nums){
        ArrayList results = new ArrayList();
        for (int i =0; i< nums.length;i++){
            int num = Integer.toString(nums[i]).length();
            if (num%2==0) {
                results.add(num);
            }
        }
        return results.size();

    }

}
