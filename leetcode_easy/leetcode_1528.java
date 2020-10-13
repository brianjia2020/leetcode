package leetcode_easy;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_1528 {
    @Test
    public void test(){
        System.out.println(restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));
    }

    public String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for(int i =0;i<indices.length;i++){
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }
}
