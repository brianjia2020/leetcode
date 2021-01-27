package leetcode;

import org.junit.Test;

public class leetcode_125 {
    @Test
    public void test(){
        String s = "A man, a plan, a canal: Panama";
        boolean b = isPalindrome(s);
        System.out.println(b);
    }

    public boolean isPalindrome(String s) {
        String src = "";
        for(char c: s.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(c)) {
                src += c;
            }
        }
        System.out.println(src.toString());
        return src.equals(new StringBuilder(src).reverse().toString());
    }
}
