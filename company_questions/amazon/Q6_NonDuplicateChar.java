package company_questions.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q6_NonDuplicateChar {
    public static void main(String[] args) {
        System.out.println(nonDuplicateChar("abcabcdfghf"));
    }

    public static Character nonDuplicateChar(String s){
        Map<Character,Integer> set = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!set.containsKey(s.charAt(i))){
                set.put(s.charAt(i),1);
            } else {
                set.put(s.charAt(i),set.get(s.charAt(i))+1);
            }
        }

        for(int i=0;i<s.length();i++){
            int count = set.get(s.charAt(i));
            if(count>1) continue;
            return s.charAt(i);
        }
        return null;
    }
}
