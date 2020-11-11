package leetcode_easy;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class leetcode_448 {

    public List<Integer> findDisappearedNumbers(int @NotNull [] nums) {
        List<Integer> ll = new LinkedList<>();
        int [] r = new int[nums.length];
        for(int x: nums) {
            r[x-1]++;
        }
        for(int i=0;i<r.length;i++){
            if (r[i] == 0) ll.add(i+1);
        }
        return ll;
    }
}
