package company_questions.amazon;

public class Q10_BreakPanlindrome {

    public static String breakPalindrome(String palindrome){
        if(palindrome==null||palindrome.length()==0) return "";
        if(palindrome.length()==1) return "";
        StringBuilder sb = new StringBuilder(palindrome);
        boolean flag = true;
        for(int i=0;i<palindrome.length()/2;i++){
            char c = palindrome.charAt(i);
            if(c>'a') {
                sb.setCharAt(i,'a');
                flag = false;
                break;
            }
        }
        if(flag) sb.setCharAt(palindrome.length()-1,'b');
        return sb.toString();
    }
}
