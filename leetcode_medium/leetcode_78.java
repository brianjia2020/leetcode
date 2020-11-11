package leetcode_medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {
    List<List<Integer>> ll;
    int [] given;

    @Test
    public void test(){
        List<List<Integer>> lists = subsets(new int[]{1, 2, 3});
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ll = new ArrayList<>();
        given = nums;
        backtrack(new boolean[nums.length], 0);
        return ll;
    }

    public void backtrack(boolean[] arr, int index){
        ll.add(getl(arr));
        for(int i =index;i < arr.length;i++){
            arr[i] = true;
            backtrack(arr,i+1);
            arr[i] = false;
        }
    }

    //create a list from the boolean array
    public List<Integer> getl(boolean[] arr) {
        List<Integer> l = new ArrayList<>();
        for(int j = 0;j<given.length;j++) {
            if(arr[j])
                l.add(given[j]);
        }
        return l;
    }
}
