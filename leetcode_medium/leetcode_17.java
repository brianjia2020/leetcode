package leetcode_medium;

import org.junit.Test;

import java.util.*;

public class leetcode_17 {
    @Test
    public void test(){
        List<String> strings = letterCombinations("23");
        System.out.println(strings.toString());
    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0){
            backtrack("",digits);
        }
        return output;
    }

    private void backtrack(String combination, String next_digits) {
        if(next_digits.length()==0){
            output.add(combination);
        } else {
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
//            System.out.println(digit);
//            System.out.println(letters);
            for(int i =0;i<letters.length();i++){
                backtrack(combination+letters.charAt(i),next_digits.substring(1));
            }
        }
    }
}
