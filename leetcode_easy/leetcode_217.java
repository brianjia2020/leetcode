package leetcode_easy;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode_217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (numbers.contains(num)) {
                return false;
            } else {
                numbers.add(num);
            }
        }
        return true;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]) return true;
        }
        return false;
    }


}
