package leetcode_medium;

import org.junit.Test;

public class leetcode_5 {
    @Test
    public void test(){
        String result = longestPalindrome("ac");
        System.out.println(result);
        System.out.println(ifPalindrome("bab"));
    }
    //1. brute force
    public String longestPalindrome(String s) {
        String result = "";
        for(int i =0; i<s.length();i++){
            String temp = "";
            for (int j=i;j<s.length();j++){
                temp += s.charAt(j);
                if (ifPalindrome(temp) && temp.length() > result.length()){
                    result = temp;
                }
            }
        }
        return result;
    }

    public boolean ifPalindrome(String s){
        if (s.length() == 1 || s.length() == 0) return true;
        boolean result = true;
        for (int i = 0;i < s.length()/2;i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    //2. pointers
    int maxLength = 0;
    int left = 0;

    public String longestPalindrome2(String s){
        for(int i =0; i <s.length();i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substring(left,left+maxLength);
    }

    public void helper(String s, int l, int r){
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if (r - l + 1> maxLength){
                left = l;
                maxLength = r - l +1;
            }
            r++;
            l--;
        }
    }
}
