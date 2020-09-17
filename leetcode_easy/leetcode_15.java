package leetcode_easy;

import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_15 {
    @Test
    public void test(){
        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        //System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum2(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < nums.length -2; i++){
            for (int j = i + 1; j < nums.length -1;j++){
                for (int z = j+1; z < nums.length;z++){
                    if((nums[i] + nums[j] + nums[z]) == 0){
                        ArrayList<Integer> temp_set = new ArrayList<>();
                        temp_set.add(nums[i]);
                        temp_set.add(nums[j]);
                        temp_set.add(nums[z]);
                        Collections.sort(temp_set);
                        if (!result.contains(temp_set)) {
                            result.add(temp_set);
                        }
                    }
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length < 3) return result;
        for (int i = 0; i <= nums.length - 3; i++){
            if(i == 0 || nums[i] != nums[i - 1])
            {
                int sum = -nums[i];
                int low = i+1;
                int high = nums.length -1;
                while(low < high){
                    if(nums[low]+nums[high]==sum){
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if(nums[low]+nums[high] < sum){
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
