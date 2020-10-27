package leetcode_easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class leetcode_46 {
    @Test
    public void test(){
        List<List<Integer>> list = permute(new int[]{1, 2, 3});
        list.forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (length == 1){
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        int start = 0;
        int end = length - 1;
        permute(nums,start,end,result);
        return result;
    }

    public void permute(int A [], int start, int end, List<List<Integer>> result){
        if (start == end){
            List<Integer> rec = new ArrayList<>();
            for (int i = 0; i <= A.length - 1; i++) {
                rec.add(A[i]);
            }
            result.add(rec);
        } else {
            for (int i = start; i <= end; i++) {
                A = swap(A,start,i);
                permute(A,start+1,end,result);
                A = swap(A,start,i);
            }
        }
    }

    public int[] swap(int A[],int x,int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
        return A;
    }
}
