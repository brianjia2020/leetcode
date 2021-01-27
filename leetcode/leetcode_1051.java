package leetcode;

import java.util.Arrays;

public class leetcode_1051 {
    public int heightChecker(int[] heights){
        if(heights==null||heights.length<=1) return 0;
        int[] copy = heights.clone();
        Arrays.sort(heights);
        int result = 0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=copy[i]){
                result++;
            }
        }
        return result;
    }
}
