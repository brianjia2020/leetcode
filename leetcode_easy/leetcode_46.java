package leetcode_easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class leetcode_46 {
    @Test
    public void test(){

    }

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (length == 1) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(nums[0]);
            result.add(res);
            return result;
        }




    }
}
