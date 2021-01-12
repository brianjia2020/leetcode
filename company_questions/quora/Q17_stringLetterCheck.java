package company_questions.quora;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q17_stringLetterCheck {
    @Test
    public void test(){
        System.out.println(stringLetterCheck("Hello, Coding Signal",new String[]{"h", "e", "h","o", "s"}));
    }

    public int stringLetterCheck(String text,String[] letters){
        if (text==null||text.length()==0) return 0;
        Set<String> set = new HashSet<>(Arrays.asList(letters));
        int count = 0;
        for(int i=0;i<text.length();i++){
            String str = text.substring(i,i+1);
            if(set.contains(str)) count++;
        }
        return count;
    }
}
