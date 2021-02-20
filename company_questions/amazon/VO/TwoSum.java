package company_questions.amazon.VO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res,-1);
        //edge cases:
        if(nums==null||nums.length<2) return res;
        //solution:
        //1. O(n^2),
        //      1.1 i=0 to nums.length-2 and j = i+1 to nums.length-1
        //      1.2 loop over all the possibilities
        //2. O(n)
        //      2.1 initiate an empty Map<Value, Position>
        //      2.2 loop over the arr and search for the (target-nums[i]) if it is in the map
        //      2.3 if not, add to the map. if it is in the map, return i, map.get(target-nums[i])

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remainder = target - nums[i];
            if(map.containsKey(remainder)){
                res[0] = i;
                res[1] = map.get(remainder);
                return res;
            } else {
                map.put(nums[i],i);
            }
        }

        return res;
    }
}
