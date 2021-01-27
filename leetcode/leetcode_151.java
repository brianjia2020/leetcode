package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_151 {
    @Test
    public void test(){
        //System.out.println(reverseWords("  Hello World. "));
        System.out.println(reverseWords("  a great  example "));
    }



    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split("\\ ");
        System.out.println(Arrays.asList(strings));
        String result = "";

        for(int i = strings.length -1 ;i >= 0; i--){
            if (!strings[i].trim().equals("")) {
                result += strings[i].trim() + " ";
            }
        }
        return result.trim();
    }
}
