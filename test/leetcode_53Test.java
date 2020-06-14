package test;

import leetcode_easy.leetcode_53;
import org.junit.Test;

import static org.junit.Assert.*;

public class leetcode_53Test {

    @Test
    public void maxSubArray() {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        leetcode_53 leetcode_53 = new leetcode_53();
        System.out.println(leetcode_53.maxSubArray(nums));
    }
}