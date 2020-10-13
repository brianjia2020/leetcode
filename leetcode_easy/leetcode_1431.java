package leetcode_easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1431 {

    @Test
    public void test(){
        int[] nums = new int[]{2,3,5,1,3};
        List<Boolean> result = kidsWithCandies(nums,3);
        result.forEach(System.out::println);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candy: candies){
            if (candy >= max) max = candy;
        }
        List<Boolean> result = new ArrayList<>();
        for(int candy: candies){
            if ((candy+extraCandies)>= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
