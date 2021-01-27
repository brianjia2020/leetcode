package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_344 {
    @Test
    public void test(){
        char[] s = "12".toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < (s.length/2); i++ ){
            temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }

}
