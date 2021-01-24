package company_questions.amazon;

import java.util.HashSet;
import java.util.Set;

public class Q19_TwoSumUniquePairs {
    public static void main(String[] args) {
        int[] nums= new int[]{1, 1, 2, 45, 46, 46};
        int target = 47;
        System.out.println(findTwoSumUniquePairs(nums,target));
    }
    public static int findTwoSumUniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num: nums){
            int remainder = target-num;
            if(remainder!=num) {
                if (set.contains(remainder) && !set.contains(num)) {
                    res++;
                }
            } else {
                if (set.contains(remainder)) {
                    res++;
                }
            }
            set.add(num);
        }
        return res;
    }
}
