package company_questions.quora;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q13_similarString {
    @Test
    public void test(){
        System.out.println(similarString("abbb","aaab"));
    }

    public boolean similarString(String one,String two){
        if (one.length()!=two.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: one.toCharArray()) {
            if (map1.containsKey(c)){
                map1.put(c,map1.get(c)+1);
            } else {
                map1.put(c,1);
            }
        }
        for (char c: two.toCharArray()) {
            if (!map1.containsKey(c)){
                return false;
            }
        }
        return true;
    }
}
