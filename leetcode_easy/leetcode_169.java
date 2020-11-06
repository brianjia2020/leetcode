package leetcode_easy;

import java.util.HashMap;

public class leetcode_169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.containsKey(num)){
                if (map.get(num) + 1 <= nums.length) {
                    map.put(num, map.get(num) + 1);
                } else {
                    return num;
                }
            } else{
                map.put(num,1);
            }
        }
        return -1;
    }


}
