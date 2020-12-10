package leetcode_easy;

import org.junit.Test;

public class leetcode_680 {
    @Test
    public void test(){
        System.out.println(validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        if (s.length()==1) return true;
        int i = 0;
        int j = s.length()-1;
        while (i < j && i <= s.length()/2 && j >= s.length()/2){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindromeRange(s,i+1,j) || isPalindromeRange(s,i,j-1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int i, int j){
        if (s.length()==1) return true;
        while (i < j && i <= s.length()/2 && j >= s.length()/2){
            if(s.charAt(i) != s.charAt(j)){
                    return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
